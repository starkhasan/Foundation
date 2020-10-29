package com.ceryl.ceryl.adapter

import com.ceryl.ceryl.activity.HomeActivity

class ExpandableListData {
    companion object{
        fun getData() : HashMap<String, List<String>>{
            val expandableListDetail = HashMap<String, List<String>>()
            val course = HomeActivity.courseContent.split("/")
            for(i in 0..course.size-1){
                val courseContentList = ArrayList<String>()
                val temp = course[i].split("(")
                val courseHeader = temp[0]
                val _courses = temp[1].substring(0,temp[1].length-1).split(",")
                for(j in 0.._courses.size-1)
                    courseContentList.add(_courses[j])
                expandableListDetail.put(courseHeader, courseContentList)
            }
            return expandableListDetail
        }
    }
}