# REST 서비스 사용하기

## REST Client
- RestTemplate
- WebClient

## RestTemplate

### 리소스 가져오기(GET)

#### getForObject
```java
Ingredient ingredient = restTemplate.getForObject(
    "http://localhost:8080/ingredients/{id}", Ingredient.class, id);
```

URL 변수들을 Map을 사용해서 지정할 수 있다.
```java
Map<String, String> urlVariables = new HashMap<>();
urlVariables.put("id", id);
URI url = UriComponentBuilder
            .fromHttpUrl("http://localhost:8080/ingredients/{id}")
            .build(urlVariables);
Ingredient ingredient = restTemplate.getForObject(url, Ingredient.class);
```

### getForEntity
도메인 객체를 포함하는 `ResponseEntity` 객체를 반환한다.

```java
ResponseEntity<Ingredient> responseEntity = restTemplate.getForEntity(
    "http://localhost:8080/ingredients/{id}", Ingredient.class, id);

Ingredient ingredient = responseEntity.getBody();
```

### 리소스 쓰기(PUT)

#### put
```java
restTemplate.put(
    "http://localhost:8080/ingredients/{id}", ingredient, ingredient.getId());
```

### 리소스 삭제하기(DELETE)

#### delete
```java
restTemplate.delete(
    "http://localhost:8080/ingredients/{id}", ingredient.getId());
```

### 리소스 데이터 추가하기(POST)

#### postForObject
```java
restTemplate.postForObject(
    "http://localhost:8080/ingredients", ingredient, Ingredient.class);
```