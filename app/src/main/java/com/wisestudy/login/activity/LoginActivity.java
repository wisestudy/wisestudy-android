package com.wisestudy.login.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.auth.ApiResponseCallback;
import com.kakao.auth.AuthService;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.Session;
import com.kakao.auth.network.response.AccessTokenInfoResponse;
import com.kakao.network.ErrorResult;
import com.kakao.util.exception.KakaoException;
import com.wisestudy.login.domain.LoginVO;
import com.wisestudy.login.dto.LoginDto;
import com.wisestudy.login.service.LoginService;
import com.wisestudy.nongroup.domain.StudyVO;
import com.wisestudy.nongroup.service.StudyService;
import com.wisestudy.user.activity.UserActivity;
import com.wisestudy.wisestudy.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginActivity extends AppCompatActivity {
    private LoginService service;
    private String accessToken;
    /**
     * 스터디 장, 스터디 멤버를 판별하는 변수
     */
    public static boolean studyCaptain = true;

    // 세션 콜백 구현
    private ISessionCallback sessionCallback = new ISessionCallback() {
        @Override
        public void onSessionOpened() {
            Log.i("KAKAO_SESSION", "로그인 성공");

            AuthService.getInstance()
                    .requestAccessTokenInfo(new ApiResponseCallback<AccessTokenInfoResponse>() {
                        @Override
                        public void onSessionClosed(ErrorResult errorResult) {
                            Log.e("KAKAO_API", "세션이 닫혀 있음: " + errorResult);
                        }

                        @Override
                        public void onFailure(ErrorResult errorResult) {
                            Log.e("KAKAO_API", "토큰 정보 요청 실패: " + errorResult);
                        }

                        @Override
                        public void onSuccess(AccessTokenInfoResponse result) {
                            Log.i("KAKAO_API", "사용자 아이디: " + result.getUserId());
                            Log.i("KAKAO_API", "남은 시간 (ms): " + result.getExpiresInMillis());
                            accessToken = Session.getCurrentSession().getAccessToken();

                            service.sendAccessToken(new Callback<LoginDto>() {
                                @Override
                                public void onResponse(Call<LoginDto> call, Response<LoginDto> response) {
                                    if(response.isSuccessful() == false){
                                        Log.d("LoginFail","Failed to register");
                                    }else{
                                        Log.d("LoginSuccess","Success to register");
                                        System.out.println("=====>" + response.body().getMessage().getJwt());
                                        successLogin();
                                    }
                                }

                                @Override
                                public void onFailure(Call<LoginDto> call, Throwable t) {
                                    System.out.println("=====>"+t.getMessage());

                                }
                            }, accessToken);
                            Log.d("KAKAO_ACCESS_TOKEN", accessToken);
                        }
                    });
        }

        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            Log.e("KAKAO_SESSION", "로그인 실패", exception);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        service = new LoginService();
        // 세션 콜백 등록
        Session.getCurrentSession().addCallback(sessionCallback);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 세션 콜백 삭제
        Session.getCurrentSession().removeCallback(sessionCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        // 카카오톡|스토리 간편로그인 실행 결과를 받아서 SDK로 전달
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void successLogin() {

        Intent intent = new Intent(getApplicationContext(), UserActivity.class);
        startActivity(intent);

    }
}
