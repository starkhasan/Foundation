from django.shortcuts import render
from purefree.models import EasyOnlineLearning
# Create your views here.
def index(request):
    obj1 = EasyOnlineLearning()
    obj1.tag = 'Easy Online Leaning'
    obj1.subtag = 'Easy Online Learning is a platform, which provide the free online study content, books, professors notes, articles and many more.'

    obj2 = EasyOnlineLearning()
    obj2.tag = 'Learn without Limit'

    obj3 = EasyOnlineLearning()
    obj3.tag = 'GitHub Repository'
    obj3.subtag = 'For Student of CS,IT and EC a free github repository is provided to access all the project, programming Language sample program, and any technology'
    obj3.special = True

    obj4 = EasyOnlineLearning()
    obj4.tag = 'EBooks'
    obj4.subtag = 'Every Student can access the eBooks related to their course of variety of famous auther and publications, you can either download the soft copy of eBooks or can read online'
    obj4.special = False

    obj5 = EasyOnlineLearning()
    obj5.tag = 'Notes, Practicle and Project'
    obj5.subtag = 'SoftCopy of the every subject notes, practicle and Project provided, but these section can not be downloaded you can only read this section.'
    obj5.special = False

    listContent = [obj3,obj4,obj5]
    mainContent = [obj1,obj2,listContent]
    return render(request, 'purefree/index.html',{'learnObject': mainContent})
