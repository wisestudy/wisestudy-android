package com.wisestudy.lib;


import com.wisestudy.groupleader.groupleaderdto.GroupLeaderDto;
import com.wisestudy.login.dto.LoginDto;
import com.wisestudy.nongroup.domain.StudyCreateVO;
import com.wisestudy.nongroup.domain.StudyVO;
import com.wisestudy.nongroup.nonGroupDto.StudyDto;
import com.wisestudy.nongroup.nonGroupDto.StudySearchDto;
import com.wisestudy.planner.vo.PlannerVO;
import com.wisestudy.user.domain.UserVO;
import com.wisestudy.user.userDto.UserResponseDto;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApi {

    @GET("/api/v1/oauth/token")
    Call<LoginDto> postKey(@Header("kakao-access-token") String key);

    /**
     * planner Api
     * @return
     */
    @GET("/api/v1/schedules")
    Call<List<PlannerVO>> getCategories();

    /**
     * nongroup Api
     */
    @GET("/api/v1/studies")
    Call<StudySearchDto> getNonGroupStudies(@Query("title") String title);

    @GET
    Call<List<StudyVO>> retrieveStudy();

    //추천 스터디 -> 스터디 클릭 -> 스터디 자세히 보기
    @GET("api/v1/studies/{studies_id}")
    Call<StudyDto> getNonGroupDetail(@Path("studies_id") String studyId);

    /**
     * GroupLeader Api
     * @return
     */
    //detail
    @GET("/api/v1/studies/{studies_id}/members")
    Call<GroupLeaderDto> getGroupLeaderDetail(@Path("studies_id") String id);

    /**
     * user Api
     */
    @GET("api/v1/users/{userId}")
    Call<UserResponseDto> getUsersId(@Path("userId") String id);

    @POST("api/v1/studies")
    Call<StudyDto> postUserCreateStudy(@Body StudyCreateVO studyCreateVO);

    @PUT("api/v1/users/{id}")
    Call<UserVO> putUserInformation(@Path("id") String id,
                         @Body UserVO userVO);
    /**
     * schedule
     * @param id
     * @return
     */
    @GET("api/v1/schedules/{userId}")
    Call<PlannerVO> getScheduleID(@Path("userId") String id);

    /**
     *
     * ManagementGroupMember Api
     *
     */
    @GET("api/v1/studies/{studies_id}/members")
    Call<GroupLeaderDto> getGroupLeaderManagementGroupMember(@Path("studies_id") String id);
    /**
     * ManagementGroupMemberDelete Api
     */
    @DELETE("/api/v1/studies/{studies_id}/members/{study_members_id}")
    Call<ResponseBody> deleteGroupMember(@Path("studies_id") String studies_id, @Path("study_members_id") String study_members_id);


}