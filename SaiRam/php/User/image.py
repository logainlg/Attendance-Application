import pygame
import pygame.camera
from VideoCapture import vidcap as vc

pygame.camera.init()
cam = pygame.camera.Camera(0,(640,480))
cam.start()
img = cam.get_image()
pygame.image.save(img,"filename.jpg")
