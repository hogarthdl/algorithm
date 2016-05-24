#coding=utf-8
#Reading words from words.txt and downloading audio of words from http://dict.youdao.com/dictvoice

import urllib
import urllib2
import os

headers = {"User-Agent":"Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; WOW64; Trident/5.0)"}

url = "http://dict.youdao.com/dictvoice"

f = open("words.txt", "r")
count = 0
os.mkdir("audio")
os.chdir('audio')
while True:
	line = f.readline()
	if line:
		word = line  #你要查的单词
		cuntry = "2" #美式为2，英式为1
		params = {"audio":word, "type":cuntry}
		data = urllib.urlencode(params)

		request = urllib2.Request(url, data, headers)
		response = urllib2.urlopen(request)

		fs = open("%d.wav"%count, 'wb')
		fs.write(response.read())#response.read() #即是返回的音频流，你可以直接发给前台不用保存
		fs.close()
		count = count + 1
	else:
		break

f.close() 

