from django.contrib import admin
from django.urls import path
from home import views

urlpatterns = [
    path('', views.index, name='home'),
    path('add',views.add, name='add'),
    path('about',views.about,name='about')
]