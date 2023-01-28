import openai
openai.api_key = "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"
response = openai.Completion.create(
  model="text-davinci-003",
  prompt="\nHuman: 請用java寫BFS演算法\nAI:",
  temperature=0.9,
  max_tokens=1000,
  top_p=1,
  frequency_penalty=0.0,
  presence_penalty=0.6,
  stop=[" Human:", " AI:"]
)
print(response["choices"][0]["text"])