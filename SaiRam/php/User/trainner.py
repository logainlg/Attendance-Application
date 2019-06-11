import cv2,os
import numpy as np
from PIL import Image
#import Image
recognizer = cv2.face.LBPHFaceRecognizer_create()

#recognizer = cv2.face.createLBPHFaceRecognizer()
#recognizer = cv2.data.createLBPHFaceRecognizer()
recognizer = cv2.face.LBPHFaceRecognizer_create()
path='dataSet'

detector= cv2.CascadeClassifier("haarcascade_frontalface_default.xml");

def getImagesWithID(path):
    imagepaths=[os.path.join(path,f) for f in os.listdir(path)]
    faces=[]
    IDs=[]
    for imagepath in imagepaths:
        faceImg=Image.open(imagepath).convert('L');
        faceNp=np.array(faceImg,'uint8')
        ID=int(os.path.split(imagepath)[-1].split('.')[1])
        faces.append(faceNp)
        IDs.append(ID)
        cv2.imshow("training",faceNp)
        cv2.waitKey(10)
    return np.array(IDs),faces

IDs,faces=getImagesWithID(path)
recognizer.train(faces,IDs)
recognizer.save('reco/trainner.yml')
cv2.destroyAllWindows()

