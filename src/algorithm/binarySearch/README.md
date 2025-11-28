# 🏆 이진탐색 총정리

## 기본 이진탐색

### 값 찾기 - O(log n)
```java
int left = 0, right = n - 1;
while (left <= right) {
    int mid = (left + right) / 2;
    if (arr[mid] == target) return mid;
    else if (arr[mid] < target) left = mid + 1;
    else right = mid - 1;
}
```

## Lower/Upper Bound

### Lower Bound: target 이상인 첫 위치
```java
int left = 0, right = n;
while (left < right) {
    int mid = (left + right) / 2;
    if (arr[mid] < target) left = mid + 1;
    else right = mid;
}
```

### Upper Bound: target 초과인 첫 위치
```java
int left = 0, right = n;
while (left < right) {
    int mid = (left + right) / 2;
    if (arr[mid] <= target) left = mid + 1;
    else right = mid;
}
```

### 활용
```java
// upper - lower = target 개수
int count = upperBound(arr, target) - lowerBound(arr, target);
```

## 파라메트릭 서치

### 조건을 만족하는 최댓값/최솟값 찾기
```java
int answer = -1;
while (left <= right) {
    int mid = (left + right) / 2;
    if (조건_만족(mid)) {
        answer = mid;
        left = mid + 1;  // 최댓값 구하기
        // right = mid - 1;  // 최솟값 구하기
    } else {
        right = mid - 1;  // 최댓값 구하기
        // left = mid + 1;  // 최솟값 구하기
    }
}
```

## 📝 이진탐색 문제 유형

### 1. 기본 탐색
- 정렬된 배열에서 값 찾기

### 2. 개수 세기
- Lower/Upper Bound 활용

### 3. 결정 문제 (파라메트릭 서치)
- **나무 자르기** (백준 2805)
- **랜선 자르기** (백준 1654)
- **공유기 설치** (백준 2110)
- **예산** (백준 2512)

## 💡 팁
- 이진탐색은 **정렬된 배열**에서 사용
- `left <= right` vs `left < right` 조건 구분 주의
- 오버플로우 방지: `mid = left + (right - left) / 2`
- 파라메트릭 서치: "조건을 만족하는 최댓값/최솟값"을 찾는 문제