from django.shortcuts import render, HttpResponse

# Create your views here.
def index(request):
    return render(request,'home.html',{'name':'Ali Hasan'})

def about(request):
    return HttpResponse('this is about')

def add(request):
    val1 = int(request.POST['num1'])
    val2 = int(request.POST['num2'])
    val2 = val1 + val2
    return render(request,'result.html',{'result': val2})