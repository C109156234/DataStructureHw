import requests
import json
import pandas as pd

class travel:
    def __init__(self) -> None:
        response=requests.get("https://quality.data.gov.tw/dq_download_json.php?nid=8116&md5_url=6c2ab89ff50cab9b9348154384613944")
        df=json.loads(response.content)

        self.df=pd.DataFrame.from_dict(df)
        # self.totalTripsPerYear=self.getTotalTripsPerYear()

    # 每年總旅次
    def getTotalTripsPerYear(self):
        return self.df[['年別','合計']].groupby('年別').sum()

    #指定年度各縣市旅次
    def getCityTotalTrips(self,year):
        currentYearData=self.df[self.df['年別']==str(year)]
        return currentYearData[['縣市別','合計']].groupby('縣市別').sum()
    #每年各景點旅遊人數
    def getTouristSpot(self,year,spot:str=""):
        currentYearData=self.df[self.df['年別']==str(year)]
        returnData=currentYearData[['細分','合計']]
        if spot=="":
            return returnData
        else:
            return returnData[returnData['細分']==spot]
        
obj = travel()
# print(obj.df)
print(obj.getTouristSpot(2012,"陽明山遊客中心"))
# print(obj.getTotalTripsPerYear())