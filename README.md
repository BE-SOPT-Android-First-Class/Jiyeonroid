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
    private val retrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val soptService: SoptService = retrofit.create(SoptService::class.java)

    private const val GITHUB_BASE_URL = "http://api.github.com"
    private val githubRetrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    val githubService: GithubService = githubRetrofit.create(GithubService::class.java)
}
```


## 3. Call, Callback 등록하여 통신 요청
```kotlin
private fun setFollowingList() {
        val call: Call<List<FollowingUserInfo>> =
            ServiceCreator.githubService.getFollowingUserInfo()
        call.enqueue(object : Callback<List<FollowingUserInfo>> {
            override fun onResponse(
                call: Call<List<FollowingUserInfo>>,
                response: Response<List<FollowingUserInfo>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        setFollowingListView(it)
                    }
                } else {
                    Log.e(logTag, "fail - set following list")
                }
            }

            override fun onFailure(call: Call<List<FollowingUserInfo>>, t: Throwable) {
                Log.e(logTag, t.toString())
            }
        })
    }
```

## 3. 배운 내용 + 추가할 내용
* Retrofit 을 이용해 서버와 통신하는 방법
* interface 구현 방법
* singleton 사용 방법

* 추가) API 적용해 구현해보기

* 반성 및 개선해야 될 점 : 단지 돌아가기만 하는 코드가 아니라 누가 보더라도 이해하기 쉽고 효율적으로 분리, 구현된 코드를 작성해야겠다고 생각했다. 

이건 그냥 로그인 성공 기념으로 📷✨

![로그인](https://user-images.githubusercontent.com/72553506/121655656-bc40a800-cad9-11eb-9ed0-51a0332fd9e5.png)
![로그인 성공](https://user-images.githubusercontent.com/72553506/121655763-d11d3b80-cad9-11eb-8ba5-aec5d78b16dd.png)
