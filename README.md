# [WEEK 1] Android Seminar
### About_ View & ViewGroup / ConstraintLayout / View Binding / Lifecycle


## 1. 화면 전환 후 데이터를 가져온 로직 정리
```kotlin
val bundle = Bundle();
                bundle.putString("userName", userName.toString())
                bundle.putString("userPwd", userPwd.toString())
                bundle.putString("usergithubId", usergithubId.toString())
                intent.putExtras(bundle)
                startActivity(intent)
```
* `intent.putExtra()` 로 데이터를 넣어주는 대신 `bundle`로 묶어서 한 번에 `intent.putExtras()` 해주는 게 더 효율적
* registerForActivityResult : startActivityForResult(), onActivityResult() deprecated - startActivity 사용하지 말기


## 2. 생명주기를 호출하고 다른 액티비티를 호출했을 경우의 로직
![생명주기](https://developer.android.com/guide/components/images/activity_lifecycle.png)


## 3. 배운 내용 + 추가할 내용 by 코드 리뷰
* with view binding -> data binding
* 모듈화, `setOnClickListener`	함수로 만들어보기
* 검증하는 로직 함수로 만들기
```kotlin
 if (userName.isNullOrBlank() || usergithubId.isNullOrBlank() || userPwd.isNullOrBlank()) {
                Toast.makeText(this@SignUpActivity, "빈칸이 있는지 확인해주세요", Toast.LENGTH_SHORT).show()
  }
```
  * 종료할 때 바로 종료되는지 확인 – 현재 signinActivity 로 이동함 - 수정 예정
  * +) 추가
    * view binding -> data binding 하면 어떤 점이 더 좋을지 생각해보기
    * startActivity register 사용, result
