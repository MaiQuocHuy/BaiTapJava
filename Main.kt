
fun menu() {
    println("1. Thêm Sinh Viên")
    println("2. Sửa Sinh Viên")
    println("3. Xóa Sinh Viên")
    println("4. Tìm kiếm Sinh Viên")
    println("5. Danh Sach Sinh Vien")
    println("6. Exit")
}

fun addStudent(listStudent: ArrayList<Student>) {
    println("Nhap ID Sinh Vien(Number): ")
    var idSinhVien: String = ""
    var nameSinhVien: String = ""
    var ageSinhVien: Int = 0
    var genderSinhVien: String = ""
    var check: Boolean = true
    while (idSinhVien == "" || ageSinhVien == 0 || nameSinhVien == "" || genderSinhVien == "") {
        println("Nhap Id Sinh Vien: ")
        idSinhVien = "21GIT"+readln().toString().uppercase().trim()
        while (check == true) {
            if(checkIdSv(listStudent, idSinhVien)) {
                check = false
            } else {
                println("Da Bi Trung ID")
                println("Nhap lai Id Sinh Vien: ")
                idSinhVien = "21GIT"+readln().toString().uppercase().trim()
            }
        }
        println("Nhap Name Sinh Vien: ")
        nameSinhVien = readln().toString().uppercase().trim()
        println("Nhap Tuoi Sinh Vien: ")
        ageSinhVien = readln().toInt()
        println("Nhap Gioi Tinh: ")
        genderSinhVien = readln().toString().uppercase().trim()
    }
    listStudent.add(Student(idSinhVien, nameSinhVien, ageSinhVien, genderSinhVien))

}

fun checkIdSv(listStudent: ArrayList<Student>, idSinhVien: String): Boolean {
    for (student in listStudent) {
        if(idSinhVien.trim().equals(student.id.uppercase().trim().substring(5))) {
            return false
        }
    }
    return true
}

fun editStudent(listStudent: ArrayList<Student>) {
    listStudent(listStudent)
    println("Nhap ID Sinh Vien Muon Sua Sau 21GIT:")
    val idSv: String = readln().toString().trim()
    if(findStudentById(listStudent, idSv)) {
        var check = false
        while (check == false) {
            println("Nhap thanh phan muon thay doi(name/age/gender):")
            var itemEdit: String = readln().lowercase().toString().trim()
            if(findExacItemEdit(itemEdit).equals("")) {
                println("Nhap lai thanh phan muon thay doi(name/age/gender) dung nhu trong ngoac:")
                itemEdit = readln().lowercase().toString().trim()
                if(!findExacItemEdit(itemEdit).equals("")) {
                    check = true
                    println("Nhap gia tri muon thay doi trong $itemEdit:")
                    val valueEdit: String = readln().toString().trim()
                    for (student in listStudent) {
                        val substringStu = student.id.substring(5).toString().trim()
                        if(substringStu.equals(idSv.trim())) {
                            editItemStu(student, findExacItemEdit(itemEdit), valueEdit)
                        }
                    }
                }
            } else {
                check = true
                if(!findExacItemEdit(itemEdit).equals("")) {
                    println("Nhap gia tri muon thay doi trong $itemEdit:")
                    val valueEdit: String = readln().toString().trim()
                    for (student in listStudent) {
                        val substringStu = student.id.substring(5).toString().trim()
                        if(substringStu.equals(idSv.trim())) {
                            editItemStu(student, findExacItemEdit(itemEdit), valueEdit)
                        }
                    }
                }
            }
        }
    } else {
        println("Nhap sai ID")
    }

}

fun findExacItemEdit(itemEdit: String): String {
    var item: String
    if(itemEdit.equals("name")) {
       item = "name"
    } else if(itemEdit.equals("age")) {
        item = "age"
    } else if(itemEdit.equals("gender")) {
        item = "gender"
    } else {
        return ""
    }
    return item
}

fun editItemStu(student: Student, itemEdit: String, valueEdit: String): Unit {
   when(itemEdit) {
       "name" -> student.name = valueEdit.trim().toString()
       "age" -> student.age = valueEdit.toInt()
       "gender" -> student.gender = valueEdit.trim().toString()
   }
}

fun isNumber(s: String?): Boolean {
    return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
}

fun deleteStudent(listStudent: ArrayList<Student>) {
    if (listStudent.size != 0) {
        listStudent(listStudent)
        var checkValidate: Boolean = false
        while (checkValidate == false) {
            println("Nhap ID sau 21GIT: ")
            val idStu = readln().toString().trim()
            if(isNumber(idStu)) {
              checkValidate = true
              if(findStudentById(listStudent, idStu)) {
                  for (student in listStudent) {
//                      println(idStu)
//                      println(student.id.substring(5).toString().trim())
                      val substringStu = student.id.substring(5).toString().trim()
                      if(substringStu.equals(idStu.trim())) {
                          listStudent.remove(student)
                          break
                      }
                  }
              } else {
                  println("Khong tim thay ID Sinh Vien")
              }
            }
        }
    } else {
        println("Danh Sach Rong")
    }
}



fun findStudentById(listStudent: ArrayList<Student>, idStu: String): Boolean {
    for (student in listStudent) {
        var substringStu = student.id.substring(5).toString();
        if(substringStu.equals(idStu)) {
            return true
        }
    }
    return false
}


fun searchStudent(listStudent: ArrayList<Student>) {
   println("Nhap ten sinh vien ma ban muon tim kiem: ")
   val nameSearch = readLine().toString().trim().uppercase()
    var check = false
    for (student in listStudent) {
        if(student.name.uppercase().toString().contains(nameSearch)) {
            check = true
            println(student.toString())
        }
    }
    if(check == false) {
        println("Khong Tim thay ten")
    }
}



fun listStudent(listStudent: ArrayList<Student>) {
    for (student in listStudent) {
        println("${student.toString()}")
    }
}

fun main(args: Array<String>) {
    var exist: Boolean = true
    var listStu = ArrayList<Student>()
    do {
        menu()
        println("Nhap Su Lua Chon: ")
        var choice = readln().toInt()
        when(choice) {
          1 -> addStudent(listStu)
          2 -> editStudent(listStu)
          3 -> deleteStudent(listStu)
          4 -> searchStudent(listStu)
          5 -> listStudent(listStu)
          6 -> exist = false
        }
    } while (exist == true)
}