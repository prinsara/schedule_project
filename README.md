
## API 명세서

### 1. 일정 생성

domain: `schedule`

url: `http://localhost:8080/schedules`

method: `POST`

path: `/schedules`

#### 01. 설명

등록할 일정 정보를 입력받아 새로운 일정을 생성하는 API

#### 02. 요청(Request)

##### a. Parameter & Querystring

```text

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

##### b. request headers

```text
Content-Type: application/json
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| Content-Type | String | 요청 데이터 형식 |

##### c. request body

```json
{
  "scheduleName": "사라의 과제 히히",
  "content": "야르야르",
  "name": "사라",
  "password": "1234"
}
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| scheduleName | String | 일정 제목 |
| content | String | 일정 내용 |
| name | String | 작성자명 |
| password | String | 비밀번호 |

#### 03. 응답(Response)

##### a. response header

```text

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

##### b. response body

성공응답:

```json
{
  "id": 1,
  "scheduleName": "사라의 과제 히히",
  "content": "야르야르",
  "name": "사라",
  "createdAt": "2026-04-13T03:33:10.233204",
  "modifiedAt": "2026-04-13T03:33:10.233204"
}
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| id | Long | 일정 식별자 |
| scheduleName | String | 일정 제목 |
| content | String | 일정 내용 |
| name | String | 작성자명 |
| createdAt | LocalDateTime | 작성일 |
| modifiedAt | LocalDateTime | 수정일 |

status: `201 Created`

### 2. 전체 일정 조회

domain: `schedule`

url: `http://localhost:8080/schedules`

method: `GET`

path: `/schedules`

#### 01. 설명

등록된 전체 일정 목록을 조회하는 API  
작성자명은 선택값이며, 입력한 경우 해당 작성자의 일정만 조회한다.

#### 02. 요청(Request)

##### a. Parameter & Querystring

```text
name=사라
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| name | String | 작성자명, 선택값 |

##### b. request headers

```text

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

##### c. request body

```json

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

#### 03. 응답(Response)

##### a. response header

```text

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

##### b. response body

성공응답:

```json
[
  {
    "id": 1,
    "scheduleName": "사라의 과제 히히",
    "content": "야르야르",
    "name": "사라",
    "createdAt": "2026-04-13T03:33:10.233204",
    "modifiedAt": "2026-04-13T03:33:10.233204"
  }
]
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| id | Long | 일정 식별자 |
| scheduleName | String | 일정 제목 |
| content | String | 일정 내용 |
| name | String | 작성자명 |
| createdAt | LocalDateTime | 작성일 |
| modifiedAt | LocalDateTime | 수정일 |

status: `200 OK`

### 3. 선택 일정 조회

domain: `schedule`

url: `http://localhost:8080/schedules/{id}`

method: `GET`

path: `/schedules/{id}`

#### 01. 설명

선택한 일정의 단건 정보를 조회하는 API

#### 02. 요청(Request)

##### a. Parameter & Querystring

```text
id=1
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| id | Long | 일정 식별자 |

##### b. request headers

```text

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

##### c. request body

```json

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

#### 03. 응답(Response)

##### a. response header

```text

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

##### b. response body

성공응답:

```json
{
  "id": 1,
  "scheduleName": "사라의 과제 히히",
  "content": "야르야르",
  "name": "사라",
  "createdAt": "2026-04-13T03:33:10.233204",
  "modifiedAt": "2026-04-13T03:33:10.233204"
}
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| id | Long | 일정 식별자 |
| scheduleName | String | 일정 제목 |
| content | String | 일정 내용 |
| name | String | 작성자명 |
| createdAt | LocalDateTime | 작성일 |
| modifiedAt | LocalDateTime | 수정일 |

status: `200 OK`

### 4. 선택 일정 수정

domain: `schedule`

url: `http://localhost:8080/schedules/{id}`

method: `PUT`

path: `/schedules/{id}`

#### 01. 설명

선택한 일정의 제목과 작성자명을 수정하는 API  
수정 시 비밀번호를 함께 전달해야 한다.

#### 02. 요청(Request)

##### a. Parameter & Querystring

```text
id=1
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| id | Long | 일정 식별자 |

##### b. request headers

```text
Content-Type: application/json
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| Content-Type | String | 요청 데이터 형식 |

##### c. request body

```json
{
  "scheduleName": "사라의 과제 히히",
  "name": "사라수정",
  "password": "1234"
}
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| scheduleName | String | 수정할 일정 제목 |
| name | String | 수정할 작성자명 |
| password | String | 비밀번호 |

#### 03. 응답(Response)

##### a. response header

```text

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

##### b. response body

성공응답:

```json
{
  "scheduleName": "사라의 과제 히히",
  "name": "사라수정"
}
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| scheduleName | String | 수정된 일정 제목 |
| name | String | 수정된 작성자명 |

status: `200 OK`

### 5. 선택 일정 삭제

domain: `schedule`

url: `http://localhost:8080/schedules/{id}`

method: `DELETE`

path: `/schedules/{id}`

#### 01. 설명

선택한 일정을 삭제하는 API  
삭제 시 비밀번호를 함께 전달해야 한다.

#### 02. 요청(Request)

##### a. Parameter & Querystring

```text
id=1
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| id | Long | 일정 식별자 |

##### b. request headers

```text
Content-Type: application/json
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| Content-Type | String | 요청 데이터 형식 |

##### c. request body

```json
{
  "password": "1234"
}
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| password | String | 비밀번호 |

#### 03. 응답(Response)

##### a. response header

```text

```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

##### b. response body

성공응답:

```json
{}
```

| 이름 | 데이터타입 | 설명 |
| --- | --- | --- |
| - | - | - |

status: `204 No Content`
