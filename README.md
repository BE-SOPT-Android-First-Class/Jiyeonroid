# [WEEK 2] Android Seminar
### About_ 부분 화면 Fragment / RecyclerView / Data & UI / List

## 1. Fragment vs Activity
- **Fragment 와 Activity 의 차이**

Fragment | Activity
|:--:|:--:|
<img src="https://images.velog.io/images/morgankim/post/dd1b5841-f21d-493d-a673-97a0e608f2c8/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-08-05%20%EC%98%A4%ED%9B%84%205.41.29.png" width="500" /> | <img src="https://images.velog.io/images/morgankim/post/c14718d6-44f1-4197-9136-8e5d2b096538/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-08-05%20%EC%98%A4%ED%9B%84%205.40.09.png" width="500" />
@@@Fragment.kt 파일 생성 | @@@Activity.kt 파일 생성
fragment_@@@.xml 파일 생성 | activity_@@@.xml 파일 생성
액티비티가 관리해줌 | 안드로이드 시스템이 관리해줌 - 그래서 AndroidManifest 에 액티비티라는 구성요소(컴포넌트) 등록해줌
<br>

_Q. fragment 를 만들면 binding 객체를 onCreateView() 에서만 접근 가능한 건가요? fragment 안에서 전역으로 접근하게 하면 안 되나요?_

_A. 네, 안 돼요._
  
app started | rotated | 생명주기
|:--:|:--:|:--:|
<img src="https://miro.medium.com/max/1388/1*ALMDBkuAAZ28BJ2abmvniA.png" alt="drawing" width="300" height="400" /> | <img src="https://miro.medium.com/max/1400/1*ukapaC23cOJSPUeZ0bUdCA.png" alt="drawing" width="300" height="400" /> | <img src="https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FcDyVCU%2Fbtq9CtTEtoA%2FkpOuUqYRAw8aVmbyKT7jpk%2Fimg.png" alt="drawing" width="300" height="400" />
 
프래그먼트에는 프래그먼트자체의 생명주기, 프래그먼트에서 구현하는 뷰의 생명주기 이렇게 두 가지 생명주기가 있다. 액티비티와 프래그먼트의 생명주기 관계를 보면, 액티비티가 켜질 때 프래그먼트도 켜진다.
다른 점은 액티비티가 `onDestroy()` 로 죽어도 프래그먼트는 destroy 가 호출되지 않고 `onDestroyView()` 만 호출되며 프래그먼트가 죽지 않은 상태에서 여러 번 `onCreateView()` 가 호출될 수 있다.
<br>
  
> 💡 뷰는 프래그먼트보다 생명주기가 짧다 = 뷰가 죽어도 프래그먼트는 살아있다
<br>
  
<img src="https://images.velog.io/images/morgankim/post/e92d9bcc-ff55-4be2-a318-e8a62c53711b/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-08-05%20%EC%98%A4%ED%9B%84%209.08.00.png" width="700" />

프래그먼트는 뷰에 대해 참조를 해야 하기 때문에 뷰가 만들어질 때 참조를 생성한다 - 해당 참조는 프래그먼트에 있다 - 프래그먼트의 생명 주기가 더 길기 때문에, 뷰가 죽은 이후에도 프래그먼트가 살아 있어서 뷰에 대한 참조가 계속 남아 있는 상황이 발생할 수 있다. 뷰를 가지고 있기 때문에 시스템은 프래그먼트를 죽이지 않고 계속 살려두어, 죽지 못하는 상태가 된다. 죽지 않고 계속 살아 있기 때문에 메모리를 계속 차지하게 되어, 불필요한 메모리를 계속 점유하는 메모리 누수가 발생한다.
  
<img src="https://images.velog.io/images/morgankim/post/9631e606-049d-4e1e-abac-ed6012a3a4ce/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-08-05%20%EC%98%A4%ED%9B%84%209.13.17.png" width="700" />
  
그래서 이렇게 사용! `_binding` 은 뷰가 만들어질 때 초기화하고 뷰가 죽으면 참조를 삭제해준다. binding 선언할 때 사진처럼 사용하는 것 추천!
<br><br>


## 2. RecyclerView
- **RecyclerView 작업 순서**
  - item 하나의 UI 확인 - item 하나의 레이아웃 파일 만들기
  ex. imageView, textView 가 필요해!
  - item data class 만들기
  리스트로 보여줄 데이터를 담는 클래스
  - UI 의 ViewHolder 만들기 - RecyclerView Adapter 만들기
  ViewHolder : 뷰를 담고 있는 레이아웃 관리
  Adapter : 데이터를 ViewHolder 로 감싸서 뷰에서 나타낼 수 있도록 하는 장치
  
  <br>
  
  ```kotlin
  class FollowingListAdapter : RecyclerView.Adapter<FollowingListAdapter.FollowingListViewHolder>()
  ```
  
  어댑터를 만들기 위해서는 RecyclerView 의 Adapter 를 상속해야 한다. <> 안에는 해당 어댑터가 데이터를 어떤 뷰로 바꿀지에 해당하는 ViewHolder 가 들어간다.
  
    ```kotlin
  val userList = mutableListOf<FollowingUserInfo>()
    ```
    
  어댑터는 ViewHolder 로 변경할 데이터를 가지고 있어야 한다.
  
    ```kotlin
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingListViewHolder {
        val binding = ItemFollowUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FollowingListViewHolder(binding)
  }
    ```
    
  어댑터에서 데이터를 뷰로 변환하기 위해 ViewHolder 를 어떻게 만들 것인지 정의해야 한다. ViewHolder 에서 뷰를 참조하고 관리하기 위해 ViewBinding 객체를 만들어준다. 생성된 객체를 기반으로 ViewHolder 에 참조할 뷰 객체를 넘겨준다.

     ```kotlin
  override fun getItemCount(): Int = userList.size
    ```
    
  모든 리스트는 전체 아이템 수를 size 로 반환한다.
  
    ```kotlin
  override fun onBindViewHolder(holder: FollowingListViewHolder, position: Int) {
        holder.onBind(userList[position])
  }
    ```
    
  데이터를 전달, ViewHolder 가 데이터를 뷰에 묶어줄 수 있도록 한다. ViewHolder 에게 리스트에서 보여줘야 할 부분의 위치에 대한 데이터를 보내준다.
  
    ```kotlin
  class FollowingListViewHolder(
        private val binding: ItemFollowUserBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(followingUserInfo: FollowingUserInfo) {
            binding.followUserName.text = followingUserInfo.userName
        }
  }
    ```
    
  ViewHolder 가 받은 데이터를 어떻게 묶어줄지 정의하는 부분이다.
  <br>
  
  - RecyclerView 배치
  - RecyclerView item 배치 확인 - LayoutManager
  
  LayoutManager : item 들의 배치 규칙을 관리
  ex. LinearLayoutManager, GridLayoutManager
  ```kotlin
  app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
  ```
  
  - RecyclerView 에 Adapter 연결하기 - Adapter 데이터 갱신하기
  <img src="https://images.velog.io/images/morgankim/post/d1166f91-78b5-4ab3-a40d-aef6ab4227e1/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202021-08-07%20%EC%98%A4%ED%9B%84%2010.13.22.png" width="500" />
  
  사용할 어댑터의 초기값을 넣어준다
  RecyclerView 의 어댑터를 내가 만든 어댑터로 설정한다
  RecyclerView 에 보여줄 데이터를 어댑터에 전달한다
  데이터가 변경되었으니 다시 그려달라고 Adapter 에 알려준다
  <br><br>
  
    _Q. 왜 ListView 를 사용하지 않고 RecyclerView 를 사용하는 걸까?_
    
    _A. ListView 를 사용하게 되면 뷰를 계속 만들어서 보여주기 때문에 findViewById 가 계속 호출된다. 
  ➡️ ViewHolder 로 해결! 만든 뷰를 ViewHolder 에 저장해 꺼내 쓰도록 해서 뷰가 계속 만들어지는 것을 방지하고 재사용성을 높여주었다. but 코드를 개발자가 직접 짜야 했고, 하나의 리스트에 다양한 뷰를 보여주기 어려웠다.
  ➡️ RecyclerView 로 해결! 뷰를 재사용하고 다양한 ViewHolder 적용이 가능해졌다._

