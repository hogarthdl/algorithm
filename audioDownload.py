#coding=utf-8
#Reading words from words.txt which contains single word in every line and downloading audio of those words from http://dict.youdao.com/dictvoice

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
		if line=='\n': #remove empty line
			continue
		word = line  #the word you gonna find
		cuntry = "2" #2 means American English，1 means British English
		params = {"audio":word, "type":cuntry}
		data = urllib.urlencode(params)

		request = urllib2.Request(url, data, headers)
		response = urllib2.urlopen(request)
		
		#fs = open("%s.mp3"%word.strip(), 'wb') #if using word's name as file's name
		fs = open("%d.wav"%count, 'wb')
		fs.write(response.read())  #response.read() means return audio 
		fs.close()
		count = count + 1
	else:
		break

f.close() 

