package com.nepplus.lottosimulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    val mWinLottoNumArr = ArrayList<Int>()


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



        }


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

                    break;
                }

            }

        }

//        ArrayList의 sort 기능 활용
        mWinLottoNumArr.sort()

//        당첨 번호 6개 확인
        for (num in mWinLottoNumArr){
            Log.d("당첨번호", num.toString())
        }


    }

    fun setValuse() {


    }


}