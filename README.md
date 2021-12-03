# WeatherBackend
weather backend code
这是一个springboot的后台，写了个restful api，返回了题面需要的参数。
由于澳大利亚天气情况的接口太难找了，我找了好几天浪费了好多时间也没找到可用的。国内的城市接口比较好找，
我就找了个国内的，也是显示3个城市的天气情况，返回的城市的天气参数都一样的。
就是说业务逻辑是一样的。
restful api ：http://localhost:8080/weather/getWeatherInfo?city=210100
其中city取值有3个，分别是大连，沈阳，鞍山的城市编号，前台传到后台的是一个string,城市编号，后台返回给前台的是对应城市的json

{
    "city": "沈阳市",
    "updatedTime": "2021-12-04 01:32:20",
    "weather": "晴",
    "temperature": "-4",
    "wind": "≤3"
}

本地截图可以见上传的文件图片。
