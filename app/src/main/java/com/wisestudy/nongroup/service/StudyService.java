package com.wisestudy.nongroup.service;

import com.wisestudy.lib.RetrofitApi;
import com.wisestudy.lib.RetrofitClient;

import com.wisestudy.nongroup.domain.StudyVO;
import com.wisestudy.nongroup.nonGroupDto.StudyDto;
import com.wisestudy.nongroup.nonGroupDto.StudySearchDto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class StudyService {

    private RetrofitApi nonGroupStudyApi;
    private RetrofitClient nonGroupRetrofitClient;

    public StudyService() {
        this.nonGroupStudyApi = nonGroupRetrofitClient.getInstance();
    }

    public void retrieveNonGroupSearchStudy(Callback<StudySearchDto> callback, String title){
        Call<StudySearchDto> call = nonGroupStudyApi.getNonGroupStudies(title);
        call.enqueue(callback);
    }

    public void retrieveStudy(Callback<List<StudyVO>> callback){
        Call<List<StudyVO>> call = nonGroupStudyApi.retrieveStudy();
        call.enqueue(callback);
    }

    public void retrieveNonGroupDetailStudy(Callback<StudyDto> callback, String studyId){
        Call<StudyDto> call = nonGroupStudyApi.getNonGroupDetail(studyId);
        call.enqueue(callback);
    }

}