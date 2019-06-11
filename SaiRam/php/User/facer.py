# module and library required to build a Face Recognition System
import face_recognition
import cv2
# objective: this code will help you in running face recognition on a video file and saving the results to a new video file.
# Open the input movie file
# "VideoCapture" is a class for video capturing from video files, image sequences or cameras
input_video = cv2.VideoCapture("input.mp4")
#"CAP_PROP_FRAME_COUNT": it helps in finding number of frames in the video file.
length = int(input_video.get(cv2.CAP_PROP_FRAME_COUNT))
# Create an output movie file (make sure resolution/frame rate matches input video!)
#  So we capture a video, process it frame-by-frame and we want to save that video, it only possible by using "VideoWriter" object
# FourCC is a 4-byte code used to specify the video codec. The list of available codes can be found in fourcc.org. It is platform dependent.
fourcc = cv2.VideoWriter_fourcc('M','P','E','G')
# 25.07-  number of frames per second (fps)
#(1280,720)- frame size
output_video = cv2.VideoWriter('output.avi', fourcc, 25.07, (1280, 720))
# Load some sample pictures and learn how to recognize them.
female_image = face_recognition.load_image_file("warina.jpg")
female_face_encoding = face_recognition.face_encodings(female_image)[0]
#  "face_recognition.face_encodings": it's a face_recognition package which returns a list of 128-dimensional face encodings
male_image = face_recognition.load_image_file("aayush.jpeg")
male_face_encoding = face_recognition.face_encodings(male_image)[0]

known_faces = [
    female_face_encoding,
    male_face_encoding
]
