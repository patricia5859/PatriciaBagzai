
import operator
import json
from math import log
import argparse


parser = argparse.ArgumentParser(description='Bm25')
parser.add_argument('--index', dest='index_file', action='store', default="index.out",help='Index File Location')
parser.add_argument('--query', dest='query_file', action='store', default="queriesInput.txt",help='Query File Location')
parser.add_argument('--max', dest='fmax', action='store',default="100",  help='Max')
args = parser.parse_args()


# constants
k1 = 1.2
k2 = 100
b = 0.75
r = 0
R = 0.0


query_ip=args.query_file
indexfile=args.index_file


# reading the queries
with open(query_ip) as f:
    text = ''.join(f.readlines())
    #print text


# creating a list of queries
queries = []
for i in text.split('\n'):
     query = i.rstrip().split()
     queries.append(query)
#print queries


# reading the input of json
with open(indexfile) as df:
    getresult=json.load(df)

# initialising Index as Index from getresult[0]
# initialising doclen as doclen from getresult[1]
Index=getresult[0]
doclen=getresult[1]
#print type(doclen)


# calculating total number of documents
N = len(doclen)


# calculating value of avdl
def cal_avdl(doclen):
    sum= 0
    for i in doclen.values():
        sum += i
    return float(sum)/(float(len(doclen)))


# formula for BM25
def cal_BM25(n,N,r,R,f,qf,b,dl,avdl):
    K= k1* ((1 - b) + b * (float(dl) / float(avdl)))
    x = log(((r + 0.5) / (R - r + 0.5)) /((n -r + 0.5) / (N - n - R + r + 0.5)))
    y = ((k1 + 1) * f) / (K + f)
    z = ((k2 + 1)* qf) / (k2 + qf)
    return (x*y*z)


# calculating score for each query term in the query,
# summing up the score fpr each query term in a query for all documents
def execute_query(query,Index,doclen):
    doc_score ={}
    qf = 1
    temp_dic = {}
    for word in query:
        if word in Index:
            temp_dic = Index[word]
            n = len(temp_dic)
            for docID, f in temp_dic.iteritems():
                dl = doclen[docID]
                avdl = cal_avdl(doclen)
                freq = f
                word_score = cal_BM25(n,N,r,R,freq,qf,b,dl,avdl)
                if docID in doc_score:
                    doc_score[docID] += word_score
                else:
                    doc_score[docID] = word_score
    return doc_score



# using all queries to derive scores for all documents
scores = [] # llist containg score for all given documents
for i in queries:
    #print i
    scores.append(execute_query(i,Index,doclen))
    #print scores


# sorting the documents on the basis of score generated,
# display the result in a particular given format
def final(lv_scores):
    qid = 1
    max = int(args.fmax)
    for i in lv_scores:
        sort_result = sorted(i.iteritems(), key = operator.itemgetter(1), reverse = True)
        rank = 1
        for j in sort_result[:max]:
            print (str(qid)+'\tQ0\t'+str(j[0])+'\t'+str(rank)+'\t'+str(j[1])+'\t Patricia')
            rank += 1
        qid += 1

# calling statement for function final
final(scores)
