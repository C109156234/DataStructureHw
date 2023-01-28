#%%
import requests
import json
import pandas as pd
import pymysql
from sqlalchemy import create_engine
import matplotlib.pyplot as plt

font={'family':'DFKai-SB',
'weight':'bold',
'size':'20'}
plt.rc('font',**font)
plt.rc('axes',unicode_minus=False)

engine=create_engine('mysql+pymysql://C109156234:mis@192.168.23.137:3306/tour?charset=utf8')

response=requests.get("https://data.gov.tw/qc_download/dq_download_json.php?nid=8116&md5_url=682b84de07067bf3770f031e9349e3c4")
a=json.loads(response.content)
df=pd.DataFrame.from_dict(a)
df.to_sql(name='totaldata',con=engine,if_exists='replace',index=False) #將抓取的資料放進資料庫

##取出2015-2019每年總旅次##
year=[]
totaltrip=[]
for i in range(int(df.loc[0,'年別']),int(df.loc[len(a)-1,'年別'])+1,1):
    year.append(str(i))
    tt=df[df['年別'].isin([str(i)])]     #以年別抓取每年的資料
    tt.to_sql(name='total%s' %(str(i)),con=engine,if_exists='replace',index=False) #將每年的資料放進資料庫
    t1=tt[['年別','合計']]
    ttrip=0
    for j in t1['合計']:
        ttrip+=int(j)
    totaltrip.append(ttrip)
tripperyear=pd.DataFrame.from_dict({'年別':year,'總旅次':totaltrip})
tripperyear.to_sql(name='totalperyear',con=engine,if_exists='replace',index=False)
tripperyear=tripperyear.set_index('年別')
tripperyear.plot(title='歷年國內觀光總旅次',figsize=[15,10]) #繪製折線圖

##每年各縣市旅次、每年各景點旅遊人數##
conn=pymysql.connect(host='192.168.23.137',port=3306,user='C109156234',passwd='mis',db='tour',charset='utf8')
cursor=conn.cursor(pymysql.cursors.DictCursor)  #傳回來是字典的資料
for u in range(int(df.loc[0,'年別']),int(df.loc[len(a)-1,'年別'])+1,1):
    cursor.execute("SELECT * FROM `total%s`;" %(str(u)))
    rows=cursor.fetchall()

    perdata=pd.DataFrame.from_dict(rows)
    for i in range(len(perdata)):           #轉換"合計"資料格式 str-->int
        perdata.loc[i,'合計']=int(perdata.loc[i,'合計'])

    cl=perdata.縣市別.unique()               #取出縣市別裡所有出現的值
    reval=[]
    for i in cl:
        region=perdata[perdata["縣市別"]==i]
        c2=0
        for i in region['合計']:
            c2+=i
        reval.append(c2)
    regiontrip=pd.DataFrame.from_dict({"縣市別":cl,"總旅次":reval})
    regiontrip=regiontrip.set_index("縣市別")
    regiontrip.plot.bar(title='%s各縣市旅次' %(str(u)),figsize=[15,10]) #繪製折線圖

    attraction=perdata[['細分','合計']]
    new_att=attraction.sort_values(['合計'],ascending=False)     #遞減排序
    h10_att=new_att.head(10)                                    #取前十筆資料
    print("%s最多旅遊人數景點--取前10名\n\n" %(str(u)),h10_att)
    print("================================\n")
conn.commit()
cursor.close()
conn.close()
#%%