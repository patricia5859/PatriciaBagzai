import json
import sys

inputfile = sys.argv[1]
outputfile = sys.argv[2]

Index={}
documentDic = {}
with open(inputfile) as f:
    i = ''.join(f.readlines())
lines = i.split('#')[1:]

documentLen={}

for i in lines:
    text = i.split()
    templist=[]
    docID = text[0]
    for i in text[1:]:
        if i.isdigit():
            continue
        else:
            templist.append(i)
    documentDic[docID] = templist
    documentLen[docID]=len(templist)
#documentLen[docID]=len(text[1:])
#print documentDic # key -> Doc #, Value -> Words

#print documentDic


for key in documentDic:
    #print documentDic[key]
    for word in documentDic[key]:
        if word in Index:
            if key in Index[word]:
                Index[word][key] +=1
            else:
                Index[word][key] = 1
        else:
            newWord = {key: 1}
            Index[word] = newWord



finalIndex=[]
finalIndex.append(Index)
finalIndex.append(documentLen)
json.dump(finalIndex, open(outputfile,'w'))

