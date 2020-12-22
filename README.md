# "슬기로운 공부생활" 안드로이드 파트 저장소
> 스터디 모임을 제공하는 모바일 애플리케이션 안드로이드 파트 저장소 입니다.

## Introduction

"슬기로운 공부생활"은 스터디 모임을 운영하고 있었던 학생들이 스터디 모임 문화를 더욱 활성화 시켜보자는 아이디어로 출발한 프로젝트 입니다.

취업 준비생들과 학생들에게 다양한 스터디 그룹의 정보, 검색할 수 있는 기능을 제공하고, 가입한 스터디들의 스케줄 알림과 스터디원들의 현재 위치를 알 수 있는 기능들을 제공합니다(추후 개발). 또, 관심 카테고리에 맞는 스터디 그룹을 추천해 자신만의 스케줄을 관리할 수 있도록 도와줍니다.

안드로이드를 통해 제공되는 서비스는 RESTful API를 제공하는 웹 서버와 통신하고 다양한 기술을 구현하려고 노력한 서비스입니다. 취업을 준비하는 사람과 대학 학부생, 현업 개발자들이 뭉쳐 모자란 지식을 채우기 위해 도전한 프로젝트입니다.

**External Storage**

- [Google Drive - 슬기로운공부생활](https://drive.google.com/drive/folders/1c73r8tay_c4sA5vNs_hEHLdTq4ZWuolu)

**Repository for each part**

- [Server part](https://github.com/wisestudy/wisestudy-server)

## Environment

**System Architecture**(/image/SystemArchitecture.png)

- **Client**:
  - OS: Android SDKs
  - HTTP Client: Retrofit
  - Asyncronous Task Manager: RxJava
  - JSON Object Mapper: Gson
  - Image Loader: Glide
- **Server**
  - WAS: Nginx 1.17 + Gunicorn 20.0.4
  - Web Application Framework: Django 3.1
  - Database: MySQL 5.7.30
  - Cache : Redis
  - Language: Python 3.7
- **AWS**
  - Ec2
  - S3
  - RDS

**Software Stack**
![software stack](/image/software_stack.png)

---

### Members

- **Android Developers**
  - *Lee, Woon-gi*: [Blog](https://mynamewoon.tistory.com/manage/posts), [GitHub](https://github.com/leewoongi)
  - *Lee, dong-woo*: [Blog](https://edw216.github.io/), [GitHub](https://github.com/edw216)
  - *Hong, jong-hyun*: [Blog](https://comcompu.tistory.com/), [GitHub](https://github.com/jonghyunH)
  - *Cho, gyu-jin*:[Blog](https://chogyujin-study.tistory.com/), [GitHub](https://github.com/GyuJin-Cho)
