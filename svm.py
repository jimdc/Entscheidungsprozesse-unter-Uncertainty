import numpy as np
import matplotlib.pyplot as plt
from sklearn import svm

positives = [[-1,3],[0,2],[0,1],[0,0]]
negatives = [[1,5],[1,6],[3,3]]
morepositives = [[-2,0],[-2,1],[-2,3],[-1,0],[-1,1],[0,0]]

Xs = [-1, 0, 0, 0, 1, 1, 3]
Ys = [3, 2, 1, 0, 5, 6, 3]

plt.scatter(Xs,Ys)
plt.show()
