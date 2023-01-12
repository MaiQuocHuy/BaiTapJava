class Student(intStu: String, nameStu: String, ageStu: Int, genderStu: String) {
     var id: String = ""
         get() = field
         set(value) {
             field = value
         }
     var name: String = ""
         get() = field
         set(value) {
             field = value
         }
     var age: Int = 0
         get() = field
         set(value) {
             field = value
         }
     var gender: String = ""
         get() = field
         set(value) {
             field = value
         }

    init {
        id = intStu
        name = nameStu
        age = ageStu
        gender = genderStu
    }

    override fun toString(): String {
        return "Student(id='$id', name='$name', age=$age, gender='$gender')"
    }


}
