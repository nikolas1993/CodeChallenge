from os import listdir
from os.path import isfile, join

import matplotlib.pyplot as plt
from kneed import KneeLocator
from sklearn.datasets import make_blobs
from sklearn.cluster import KMeans
from sklearn.metrics import silhouette_score
from sklearn.preprocessing import StandardScaler
import numpy as np
class Antenna:
    def __init__(self,idx,r,s):
        self.id=idx
        self.r = r
        self.s = s
        self.x=-1
        self.y=-1
    def __str__(self):
        return "%d,%d" % (self.id,self.s)

    def __repr__(self):
        return "%d,%d" % (self.id,self.s)

class Building:
    def __init__(self,x,y,l,c):
        self.x=x
        self.y=y
        self.l=l
        self.c=c

def print_output(listAntennas):
    f = open("%s.out" % dataset,"w")
    output = "%d\r\n" % len(listAntennas)
    for idx, a in enumerate(listAntennas):
        output+="%d %d %d\r\n" % (a.id,a.x,a.y)
    f.write(output)
    f.close()

for dataset in [f for f in listdir(".") if isfile(join(".",f)) and f.endswith(".in")]:
    print("Working on dataset: %s" % dataset)
    with open(dataset) as fp:
        #Declarations
        listAntennas=[]
        listBuildings=[]
        line = fp.readline()
        w, h = [int(x) for x in line.split(" ")]
        city = [[None for y in range(0,h)] for x in range(0,w)] 
        line = fp.readline()
        km = []
        n, m, r = [int(x) for x in line.split(" ")]
        print("Heigth:%d,Width:%d,Buildings:%d,Antennas:%d,Prize:%d" % (h,w,n,m,r))
        for b in range(0,n):
            line = fp.readline()
            b_x, b_y, b_l, b_c = [int(x) for x in line.split(" ")]
            bu = Building(b_x,b_y,b_l,b_c)
            listBuildings.append(bu)
            km.append([b_x,b_y])
            city[b_x][b_y]=bu
        a_id=0
        for a in range(0,m):
            line = fp.readline()
            a_r, a_c = [int(x) for x in line.split(" ")]
            an = Antenna(a_id,a_r,a_c)
            listAntennas.append(an)
            a_id+=1
        
        X = np.array(km,np.int32)
        kmeans = KMeans(init="random",n_clusters=m,n_init=10,max_iter=300,random_state=42)
        kmeans.fit(X)
        y_kmeans = kmeans.predict(X)
        #plt.scatter(X[:, 0], X[:, 1], c=y_kmeans, s=50, cmap='viridis')
        centers = kmeans.cluster_centers_
        #plt.scatter(centers[:, 0], centers[:, 1], c='black', s=200, alpha=0.5);
        #plt.show()
        #print("Centers:%s"% centers)
        #print("Cluster:%s"%kmeans.labels_)
        assignation = [(0,0) for a in range(0,m)]
        for idx,b in enumerate(kmeans.labels_):
            assignation[b]=(b,assignation[b][1]+listBuildings[idx].c)
        assignation=sorted(assignation, key=lambda x:x[1], reverse=True)
        #print("Assignation:%s"%assignation)
        listAntennas=sorted(listAntennas, key=lambda x: x.s,reverse=True)
        #print(listAntennas)
        for idx,b in enumerate(assignation):
            listAntennas[idx].x=int(centers[b[0]][0])
            listAntennas[idx].y=int(centers[b[0]][1])
        print_output(listAntennas)