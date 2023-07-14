import org.junit.jupiter.api.Test;

public class BaseBallAppTest {

    @Test
    public void input_parsing_test(){
        // given
        String input = "야구장등록?name=창원NC파크";

        // when
        String action = input.split("\\?")[0]; // 야구장등록
        String queryString = input.split("\\?")[1]; // name=창원NC파크
        String[] params = queryString.split("&");
        System.out.println(params[0]);
        // params[0] = name=창원NC파크
    }

    @Test
    public void input_parsing2_test(){
        // given
        String input = "선수등록?teamId=4&name=심창민&position=투수";

        // when
        String action = input.split("\\?")[0]; // 선수등록
        String queryString = input.split("\\?")[1]; // teamId=4&name=심창민&position=투수
        String[] params = queryString.split("&");
        System.out.println(params[0]);
        System.out.println(params[1]);
        System.out.println(params[2]);
        // params[0] = teamId=4
        // params[1] = name=심창민
        // params[2] = position=투수
    }


}
