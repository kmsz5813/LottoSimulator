package com.nepplus.lottosimulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*
import kotlin.collections.ArrayList
import kotlin.coroutines.coroutineContext
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    val mWinLottoNumArr = ArrayList<Int>()

    var mBounsNum = 0

//    내가 쓴 금액? 합산 변수
    var mUsedMoney = 0L // Long 타입 (긴 숫자 표현) 명시
//    당첨 금액? 합산변수
    var mEarnedMoney = 0L


    lateinit var mLottoNumTxtList : ArrayList<TextView>

    val mMyLottoNumArr = arrayListOf(5,14,25,30,38,42)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvunets()
        setValuse()


    }
    fun setupEvunets() {

        btnBuyLotto.setOnClickListener {

//            로또 번호 6개 생성
            makeLottoNumbers()

//            보너스번호 생성
            makeBounsNum()




        }

        fun checkLottoRank() {

//            1천원 사용으로 간주,
            mUsedMoney += 1000

            txtUsedMoney.text = "${NumberFormat.getInstance(Locale.KOREA).format(mUsedMoney)}원"


            var correctCount = 0

            for(myNum in mMyLottoNumArr){

//                맞췄는가? -> myNum이 당첨번호에 들어있는가?
                if( mWinLottoNumArr.contains(myNum)){
//                    맞춘 갯수 증가

                    correctCount++
                }

            }

            Log.d("맞춘 갯숫", "${correctCount}개 맞춤")

//            등수판다

            when(correctCount){
                6 -> {
                    Log.d("등수","1등입니다!")

                }
                5 -> {
//                    보너스 번호 검사 => 보너스 번호가 내 번호안에 있는가?

                    if(mMyLottoNumArr.contains(mBounsNum)){
                        Log.d("등수","2등")

                    }
                    else{
                        Log.d("등수","3등")
                    }


                }
                4 -> {
                    Log.d("등수","4등")

                }
                3 -> {
                    Log.d("등수","5등")

                }
                else -> {
                    Log.d("등수","꽝")
                }

            }



        }


    }
    fun makeBounsNum() {

//        써도 되는 숫자가 나올때까지 무한 반복
        while (true){

            val randomNum = (1..45).random()

            val isDuplOk = !mWinLottoNumArr.contains(randomNum)

            if (isDuplOk){
                mBounsNum = randomNum
                break

            }

        }

//        보너스번호 텍스튜베 반영
        txtBonusNum.text = mBounsNum.toString()


    }

    fun makeLottoNumbers(){

//        기존에 번호가 있다면 전부 삭제.
        mWinLottoNumArr.clear()

//        6개의 당첨 번호 => 반복 횟수 명확 => for

        for(i in 0 until 6){

//            랜덤 숫자 추출 -> (제대로 된 숫자라면) 목록에 추가

            while (true){

                val randomNum = (Math.random() * 45 + 1).toInt()

//                중복검사 : 당첨 숫자 목록에 내 숫자가 있는지?


                val isDuplOk = !mWinLottoNumArr.contains(randomNum)


                if(isDuplOk){

//                    숫자를 당첨 목록에 추가.
                    mWinLottoNumArr.add(randomNum)

                    break
                }

            }

        }

//        ArrayList의 sort 기능 활용
        mWinLottoNumArr.sort()

//        당첨 번호 6개 확인
       for (i in 0 until 6) {

//           텍스트뷰[i] = 당첨번호 [i]

           mLottoNumTxtList[i].text = mWinLottoNumArr[i].toString()

       }


    }

    fun setValuse() {
        mLottoNumTxtList =  arrayListOf(txtLottoNum1,txtLottoNum2,txtLottoNum3,txtLottoNum4,txtLottoNum5,txtLottoNum6)

    }


}