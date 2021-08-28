# [WEEK 4] Android Seminar
### About_ Retrofit

## 1. 서버 통신 구현 과정 
1. 서버 API 문서(명세서) 확인 후 PostMan Test
2. Retrofit Interface 설계 (서벙 어떻게 요청을 보내고 받는지 정의)
3. 서버 Request, Response 객체 설계
4. Retrofit Interface 구현체 만들기 (interface 라는 상호작용규칙이 어떻게 작용하늕 구현)
5. `callback` 을 등록해서 통신 요청


## 2. Retrofit Builder 구현체 생성
```kotlin
object ServiceCreator {
    private const val BASE_URL = "http://cherishserver.com"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val soptService: SoptService = retrofit.create(SoptService::class.java)

    private const val GITHUB_BASE_URL = "https://api.github.com"

    private val retrofit_github: Retrofit =
        Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()
    val githubService: GithubService = retrofit_github.create(GithubService::class.java)
}
```


## 3. Call, Callback 등록하여 통신 요청
```kotlin
private fun requestFollower() {
        val call: Call<List<FollowingListInfo>> =
            ServiceCreator.githubService.getFollowerInfo("todayiswindy")

        call.enqueue(object : Callback<List<FollowingListInfo>> {
            override fun onResponse(
                call: Call<List<FollowingListInfo>>,
                response: Response<List<FollowingListInfo>>
            ) {
                if (response.isSuccessful) {
                    setFollowingList()
                }
            }

            override fun onFailure(call: Call<List<FollowingListInfo>>, t: Throwable) {
                Log.d("로그", "error:$t")
            }
        })
    }
```

1. 서버로 보낼 id(email), password 를 DataClass 로 묶어준다.
2. 아까 만든 싱글턴 객체를 이용해서 Retrofit 이 만들어준 interface 구현체에 접근하여 Call 객체를 받아온다.
3. call 객체에 enqueue 를 호출하여 실제 서버 통신을 비동기적으로 요청한다.
4. Call 객체는 비동기 작업 이후에 할 행동을 Callback 객체로 표현한다.
5. 비동기 통신 이후 Response(응답 데이터) 내부에는 해당 요청이 성공했는지 판단하는 isSuccessful, ResponseLoginData(받아오겠다고 명시한 데이터) 를 받는 body()
(cf. 이외에도 서버 상태를 알 수 있는 code(), header 를 찾아오는 header() 등 다양한 함수, 프로퍼티가 있다.)
6. 우리가 만든 ResponseLoginData 는 응답 객체인 Response 의 body() 로 가져올 수 있는데
    - 해당 body() 는 nullable 하다 - body 가 오지 않는 경우도 있기 때문
    - body 의 data 또한 nullable 하다 - 우리가 nullable 하다 선언했기 때문 - why? 만약 서버 통신에서 400 을 던져주면 data 가 없기 때문
7. 비동기 통신 중 발생한 에러를 처리한다.

## 3. 배운 내용 + 추가할 내용
* Retrofit 을 이용해 서버와 통신하는 방법
* interface 구현 방법
* singleton 사용 방법
* API 적용해 구현해보기

* 반성 및 개선해야 될 점 : 단지 돌아가기만 하는 코드가 아니라 누가 보더라도 이해하기 쉽고 효율적으로 분리, 구현된 코드를 작성해야겠다고 생각했다. 

이건 그냥 로그인 성공 기념으로 📷✨

![로그인](https://user-images.githubusercontent.com/72553506/121655656-bc40a800-cad9-11eb-9ed0-51a0332fd9e5.png)
![로그인 성공](https://user-images.githubusercontent.com/72553506/121655763-d11d3b80-cad9-11eb-8ba5-aec5d78b16dd.png)
