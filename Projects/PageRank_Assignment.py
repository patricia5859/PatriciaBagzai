from __future__ import division
from math import log
import operator

dic ={} # dictionary having nodes as keys and there in links as values
List_P = list() # list containing all nodes
List_M =list() # list containing all the values of dictionary dic
List_S = list() # list containing all nodes with 0 out links
L = {} # dictionary having nodes as keys and no. of out links as values
Len = {} # dictionary containing nodes as keys and no. of inlinks as values
d = 0.85 # d is the PageRank damping/teleportation factor; use d = 0.85 as a fairly typical value
N = 0
PR ={} # dictionary which will contain Page Ranks
newPR = {} # dictionary which will hold temporary values
Perp = list() # a list used in calculating perplexity
Dict_Inlinks = {} #  dictionary containing number of inlinks as values
#PR = 1/N # PR(p) is the page rank of page p


# inserting in dictionary: first col as keys and remaining incoming nodes as values
# dic is M_p
# with open('graphs_input.txt') as f:
with open('H:\IR\In-Links.txt') as f:
    for line in f:
        splitline = line.split()
        dic[str(splitline[0])] = splitline[1:]
# print "dic", dic

######################################################################################

# inserting in List_p : all nodes
for i in  dic.keys():
    List_P.append(i)
# print "List_P", List_P

######################################################################################

# initialising variable N with number of nodes:
N = List_P.__len__()

######################################################################################

# creating dictionary PR: with nodes as keys and 1/N as the values for each node
PR = dic.fromkeys(List_P, (1/N))
# print "PR",PR

######################################################################################

# initialising newPR: as empty
newPR = {}
# print "newPR", newPR

######################################################################################

# creating List_M : containing all the values of dictionary "dic"
for i in  dic.values():
    List_M.append(i)
# print "List_M", List_M

######################################################################################

# initialising L : all the values of dictionary as 0
for i in List_P:
    L[i]=0

######################################################################################

# creating dictionary L : counting no. of out links from a node, as values to L
for j in dic.values():
    for i in j:
        if i == ' ':
            continue
        L[i] +=1
# print "L", L

######################################################################################

# creating List_S : with nodes that have no out links
for i in L:
    if L[i] == 0:
        List_S.append(i)
# print "List_S", List_S

######################################################################################

# definition of prep(), calculating perplexity:
def perp():
    en =0
    for i in PR:
        en += PR[i]*log(1/PR[i], 2)
    #print "Entropy->",en
    return 2**en

######################################################################################

# definition of convrg(), finding if the perplexity values have converged upto units
#  place or not
def convrg(i):
    perpvalue = perp()
    print "Perplexity No.->",i," Perplexity Value->",perpvalue
    Perp.append(perpvalue)
    if (len(Perp)>4):
        if ((int(Perp[i]))==(int(Perp[i-1]))==(int(Perp[i-2]))==(int(Perp[i-3]))):
            # print i+1, prep()
            return False
        else:
            return True
    else:
        return True

######################################################################################

# Loop for calculating page ranks:
i = 0
while convrg(i):
    perp()
#while (i<100):
    sinkPR = 0
    for p in List_S:
        sinkPR += PR[p]
    for p in List_P:
        newPR[p] = (1-d)/N
        newPR[p] += d*(sinkPR/N)
        for q in dic[p]:
            newPR[p] += d*PR[q]/L[q]
    sum = 0
    for p in List_P:
        PR[p] = newPR[p]
        sum += PR[p]
    # print sum
    # print "Loop no.->",i
    # if i == 5 :
    #     break
    i += 1

######################################################################################

# creating a dictionary Sorted_PR : conatainig page ranks in sorted (decreasing) order
Sorted_PR= (sorted(PR.items(), key=operator.itemgetter(1), reverse=True))
# print Sorted_PR

######################################################################################

# determining top 50 Page Ranks:
i=0
fw = open('Top50Docs.txt', 'w')
count = 0
for i in Sorted_PR:
    fw.write(str(i)+"\n")
    count = count +1
    if(count == 50):
        break
fw.close()

######################################################################################


# creating a dictionary Dict_Inlinks : with values as no. of inlinks:
for i in dic:
     Dict_Inlinks[i] = len(dic[i])

######################################################################################

# creating a dictionary Sorted_inLinks : containing count of inLinks in sorted
# (decreasing) order
Sorted_inLinks = (sorted(Dict_Inlinks.items(), key=operator.itemgetter(1), reverse=True))

######################################################################################

# determining pages with top 50 in links:
count = 0
fw= open ('Top50_inLinks.txt', 'w')
for i in Sorted_inLinks:
    fw.write(str(i)+"\n")
    count += 1
    if (count == 50):
        break
fw.close()

######################################################################################

# calculating proportion of pages with no inlinks:
count = 0
for i in dic:
    if (len(dic[i]) == 0):
        count +=1

print ("\nProportion of inLink counts", (count/List_P.__len__()))

######################################################################################

# calculating proportion of pages with no outlinks:
print ("\nProportion of 0 outlinks", ((List_S.__len__())/List_P.__len__()))

######################################################################################

# Proportion of pages with new PageRank less than initial ones:
count =0
for i in PR:
    if (PR[i] < (1/N)):
        count += 1
print ("\nProportion of pages with new PageRank less than initial ones", (count/List_P.__len__()))

######################################################################################