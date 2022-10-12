import com.ilb.domain.Bread;
import com.ilb.service.BreadPredicator;
import com.ilb.service.BreadService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 빵 전체 목록
        List<Bread> breads = new ArrayList<>();
        breads.add(new Bread("미니초코튀소", "성심당", 2000, true));
        breads.add(new Bread("작은메아리", "성심당", 2800, false));
        breads.add(new Bread("카카오순정", "성심당", 2800, true));
        breads.add(new Bread("모찌모찌식빵", "성심당", 3000, false));
        breads.add(new Bread("월넛브래드", "성심당", 3000, false));
        breads.add(new Bread("돌아온고오스초코케익", "(주)에스피씨삼립", 1500, true));
        breads.add(new Bread("돌아온로켓단초코롤", "(주)에스피씨삼립", 1500, true));
        breads.add(new Bread("돌아온이슬의초코파운드", "(주)에스피씨삼립", 1500, true));
        breads.add(new Bread("파이리의화르륵핫소스빵", "(주)에스피씨삼립", 1500, false));

        BreadService breadService = new BreadService();

        // case 1 : 익명클래스 사용, 초코빵만 모오기
        List<Bread> chocoBreads = breadService.filterBread(breads, new BreadPredicator() {
            @Override
            public boolean test(Bread bread) {
                return bread.isChoco;
            }
        });

        // case 2 : 람다 사용, 가격이 2800원인 빵
        List<Bread> price2800Breads = breadService.filterBread(breads, b -> b.price == 2800);

        // case 3 : 스트림 사용, 성심당 빵의 이름만 추출할 건데 오름차순으로 3개만
        List<String> sungsimBreadNames = breads.stream()
            .filter(b -> b.store.equals("성심당"))
            .map(b -> b.name)
            .sorted()
            .limit(3)
            .collect(Collectors.toList());
    }
}
