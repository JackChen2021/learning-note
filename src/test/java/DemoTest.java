import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.AtomicDouble;
import com.learning.client.*;
import com.learning.LearnApplication;
import com.learning.offer.DemoMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.mockito.ArgumentMatchers.doubleThat;
import static org.mockito.Mockito.when;

/**
 * <pre>
 * @Description:
 * </pre>
 *
 * @version v1.0
 * @ClassName: DemoTest
 * @Author: 86159
 * @Date: 2020/3/25 22:08
 */
//@RunWith(SpringRunner.class)
////启动Spring
//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT,classes = LearnApplication.class)
@DirtiesContext
public class DemoTest {

    @Autowired
    BaiduMapClient baiduMapClient;

    public final static String AK = "3pkCQmAqaDlPBHAiI3HE3VA9GZP9vG1M";

    @Test
    public void demo() {
        DemoMock demoMock = Mockito.mock(DemoMock.class);
        when(demoMock.doTest()).thenReturn(Collections.singletonList("123"));
        Mockito.doNothing().when(demoMock.doTest());
    }

    @Test
    public void roadFormat(){
//        double[][] road = {
//                {0.0, 186839.0, 178449.0, 329124.0, 128794.0, 215349.0, 216527.0, 240100.0, 241289.0, 327655.0, 196548.0, 261768.0, 237561.0, 101043.0, 81075.0, 85314.0, 278714.0, 434474.0, 570914.0, 278294.0, 201572.0, 335056.0, 435956.0, 500573.0, 541344.0, 385832.0, 274646.0, 262417.0, 397253.0, 297151.0},
//                {185468.0, 0.0, 58529.0, 482939.0, 62942.0, 42193.0, 55112.0, 67757.0, 108634.0, 407670.0, 305629.0, 223861.0, 199654.0, 168427.0, 137094.0, 105379.0, 200851.0, 274200.0, 482261.0, 126980.0, 147580.0, 217948.0, 354577.0, 335257.0, 401436.0, 239303.0, 238883.0, 137084.0, 310460.0, 131835.0},
//                {176295.0, 58071.0, 0.0, 430308.0, 53769.0, 86397.0, 69531.0, 111148.0, 99593.0, 355039.0, 252998.0, 171230.0, 147023.0, 122622.0, 127921.0, 96206.0, 237215.0, 310564.0, 518625.0, 163344.0, 171998.0, 254312.0, 390941.0, 371621.0, 437800.0, 275667.0, 269505.0, 173448.0, 346824.0, 159383.0},
//                {327259.0, 482751.0, 429719.0, 0.0, 420220.0, 511077.0, 494211.0, 535828.0, 482586.0, 205576.0, 185285.0, 309105.0, 370563.0, 329024.0, 354000.0, 387215.0, 596543.0, 735244.0, 888743.0, 588024.0, 519401.0, 652885.0, 753785.0, 796301.0, 862480.0, 700347.0, 592475.0, 580246.0, 715082.0, 584063.0},
//                {127310.0, 64261.0, 55871.0, 420051.0, 0.0, 92771.0, 93949.0, 117522.0, 122123.0, 344782.0, 242741.0, 205109.0, 180902.0, 110269.0, 78936.0, 47221.0, 217057.0, 316938.0, 521646.0, 169718.0, 139915.0, 260686.0, 393962.0, 377995.0, 444174.0, 282041.0, 237422.0, 179822.0, 349845.0, 174573.0},
//                {214149.0, 42361.0, 85656.0, 510066.0, 91623.0, 0.0, 57577.0, 22963.0, 108210.0, 434797.0, 332756.0, 250988.0, 214721.0, 197108.0, 165775.0, 134060.0, 158332.0, 231681.0, 439742.0, 84461.0, 105061.0, 175429.0, 312058.0, 292738.0, 358917.0, 196784.0, 196364.0, 94565.0, 267941.0, 100525.0},
//                {216453.0, 54636.0, 69966.0, 494376.0, 93927.0, 53231.0, 0.0, 69349.0, 68686.0, 411725.0, 317066.0, 235298.0, 178204.0, 186690.0, 168079.0, 136364.0, 195416.0, 266683.0, 476826.0, 121545.0, 142145.0, 212513.0, 349142.0, 327740.0, 396001.0, 233868.0, 233448.0, 131649.0, 305025.0, 103582.0},
//                {234716.0, 68314.0, 106223.0, 530633.0, 112190.0, 22069.0, 70042.0, 0.0, 120675.0, 455364.0, 353323.0, 271555.0, 239912.0, 217675.0, 186342.0, 154627.0, 134483.0, 207832.0, 415893.0, 60612.0, 81212.0, 151580.0, 288209.0, 268889.0, 335068.0, 172935.0, 172515.0, 70716.0, 244092.0, 97409.0},
//                {240933.0, 112554.0, 99797.0, 477235.0, 120905.0, 103903.0, 67483.0, 120021.0, 0.0, 360497.0, 299925.0, 187352.0, 126976.0, 169549.0, 171787.0, 160613.0, 245121.0, 298315.0, 526531.0, 165586.0, 192817.0, 262218.0, 398847.0, 359372.0, 445800.0, 246839.0, 284120.0, 182321.0, 354730.0, 127525.0},
//                {326361.0, 409259.0, 356227.0, 204854.0, 346728.0, 437585.0, 410522.0, 462336.0, 359509.0, 0.0, 128315.0, 193773.0, 256296.0, 283013.0, 312295.0, 321303.0, 547483.0, 650837.0, 852072.0, 514532.0, 470341.0, 605500.0, 724388.0, 711894.0, 788988.0, 599361.0, 569671.0, 524636.0, 680271.0, 480047.0},
//                {194542.0, 307759.0, 254727.0, 184503.0, 245228.0, 336085.0, 319219.0, 360836.0, 307594.0, 128165.0, 0.0, 134113.0, 195571.0, 180770.0, 205746.0, 219803.0, 445983.0, 560252.0, 756026.0, 413032.0, 368841.0, 504000.0, 621068.0, 621309.0, 687488.0, 525355.0, 459758.0, 423136.0, 582365.0, 409071.0},
//                {261482.0, 224716.0, 171684.0, 308833.0, 206254.0, 253042.0, 236176.0, 277793.0, 187529.0, 195011.0, 133702.0, 0.0, 84316.0, 170728.0, 200010.0, 181162.0, 403860.0, 478857.0, 685270.0, 329989.0, 329867.0, 420957.0, 557586.0, 539914.0, 604445.0, 442312.0, 427374.0, 340093.0, 513469.0, 308067.0},
//                {236064.0, 206397.0, 146266.0, 371329.0, 180836.0, 215786.0, 177553.0, 239574.0, 126540.0, 257708.0, 196198.0, 84563.0, 0.0, 145310.0, 174592.0, 155744.0, 364674.0, 417868.0, 646084.0, 285139.0, 304449.0, 381771.0, 518400.0, 478925.0, 565353.0, 366392.0, 403673.0, 301874.0, 474283.0, 247078.0},
//                {98875.0, 170744.0, 121388.0, 328905.0, 112699.0, 199254.0, 185880.0, 224005.0, 168842.0, 281837.0, 180804.0, 170404.0, 146197.0, 0.0, 36004.0, 69219.0, 297448.0, 423421.0, 589648.0, 276201.0, 220306.0, 353790.0, 454690.0, 484478.0, 550657.0, 388524.0, 293380.0, 281151.0, 415987.0, 275732.0},
//                {80906.0, 138534.0, 130144.0, 354362.0, 80489.0, 167044.0, 168222.0, 191795.0, 171605.0, 311281.0, 206261.0, 199848.0, 175641.0, 35304.0, 0.0, 37009.0, 270060.0, 391211.0, 562260.0, 243991.0, 192918.0, 326402.0, 427302.0, 452268.0, 518447.0, 356314.0, 265992.0, 253763.0, 388599.0, 248846.0},
//                {85213.0, 105992.0, 97602.0, 387230.0, 47947.0, 134502.0, 135680.0, 159253.0, 160258.0, 325834.0, 223793.0, 180737.0, 156530.0, 68172.0, 36839.0, 0.0, 247349.0, 358669.0, 551938.0, 211449.0, 170207.0, 302417.0, 424254.0, 419726.0, 485905.0, 323772.0, 267714.0, 221553.0, 380137.0, 216304.0},
//                {280023.0, 204868.0, 240875.0, 597852.0, 219542.0, 161439.0, 199001.0, 138088.0, 248316.0, 548050.0, 446009.0, 406207.0, 367553.0, 298123.0, 270813.0, 250489.0, 0.0, 156738.0, 304063.0, 87205.0, 87538.0, 57320.0, 176379.0, 226213.0, 263608.0, 108096.0, 54745.0, 63904.0, 132262.0, 177012.0},
//                {433546.0, 274548.0, 310555.0, 734965.0, 316522.0, 231119.0, 266310.0, 207768.0, 298265.0, 651023.0, 557655.0, 475887.0, 417502.0, 422007.0, 390674.0, 358959.0, 156511.0, 0.0, 265191.0, 160639.0, 241061.0, 121801.0, 243705.0, 86153.0, 176476.0, 59126.0, 207255.0, 176645.0, 190716.0, 226634.0},
//                {571916.0, 484283.0, 520290.0, 889745.0, 522900.0, 440854.0, 478416.0, 417503.0, 527731.0, 851408.0, 749367.0, 685622.0, 646968.0, 590016.0, 562706.0, 553847.0, 304813.0, 264678.0, 0.0, 366620.0, 390896.0, 276850.0, 217629.0, 355454.0, 131295.0, 313010.0, 340407.0, 343319.0, 213673.0, 456427.0},
//                {277260.0, 127879.0, 163886.0, 588296.0, 169853.0, 84450.0, 122012.0, 61099.0, 165966.0, 513027.0, 410986.0, 329218.0, 285203.0, 275338.0, 244005.0, 212290.0, 84377.0, 161553.0, 365787.0, 0.0, 81574.0, 101474.0, 238103.0, 222610.0, 284962.0, 122829.0, 139946.0, 25248.0, 193986.0, 98482.0},
//                {201392.0, 149747.0, 173195.0, 519221.0, 140911.0, 106318.0, 143880.0, 78431.0, 194513.0, 469419.0, 367378.0, 329746.0, 305539.0, 219492.0, 192182.0, 171858.0, 85540.0, 241300.0, 390129.0, 86411.0, 0.0, 141882.0, 262445.0, 310775.0, 348170.0, 192658.0, 105905.0, 70534.0, 218328.0, 149539.0},
//                {334280.0, 218343.0, 254350.0, 652109.0, 260317.0, 174914.0, 212476.0, 151563.0, 261791.0, 603491.0, 501450.0, 419682.0, 381028.0, 352380.0, 325070.0, 302754.0, 57245.0, 121229.0, 275350.0, 100680.0, 141795.0, 0.0, 163908.0, 190704.0, 208764.0, 72587.0, 105947.0, 77379.0, 119791.0, 190487.0},
//                {435916.0, 355729.0, 391736.0, 753745.0, 394346.0, 312300.0, 349862.0, 288949.0, 399177.0, 722854.0, 621169.0, 557068.0, 518414.0, 454016.0, 426706.0, 425293.0, 176259.0, 242323.0, 215306.0, 238066.0, 262342.0, 164089.0, 0.0, 324310.0, 217332.0, 224290.0, 201720.0, 214765.0, 64160.0, 327873.0},
//                {500227.0, 335727.0, 371734.0, 796144.0, 377701.0, 292298.0, 327489.0, 268947.0, 359444.0, 712202.0, 618834.0, 537066.0, 478681.0, 483186.0, 451853.0, 420138.0, 226076.0, 86490.0, 356193.0, 221818.0, 310626.0, 191366.0, 324549.0, 0.0, 267478.0, 128691.0, 276820.0, 239428.0, 271560.0, 287813.0},
//                {538650.0, 400718.0, 436725.0, 861135.0, 442692.0, 357289.0, 394851.0, 333938.0, 444277.0, 785866.0, 683825.0, 602057.0, 563514.0, 548177.0, 516844.0, 485129.0, 261615.0, 173903.0, 131775.0, 283055.0, 346165.0, 206924.0, 215991.0, 264679.0, 0.0, 222235.0, 312359.0, 281607.0, 212288.0, 372973.0},
//                {383770.0, 238535.0, 274542.0, 698952.0, 280509.0, 195106.0, 232668.0, 171755.0, 246585.0, 623683.0, 521642.0, 439874.0, 365822.0, 385994.0, 354661.0, 322946.0, 106735.0, 59406.0, 312227.0, 120872.0, 191285.0, 72025.0, 224259.0, 128881.0, 223512.0, 0.0, 157479.0, 126869.0, 180142.0, 174954.0},
//                {275120.0, 240616.0, 271405.0, 592949.0, 239121.0, 197187.0, 234749.0, 173836.0, 285382.0, 569197.0, 460373.0, 427956.0, 404619.0, 293220.0, 265910.0, 270068.0, 54816.0, 207194.0, 328201.0, 135100.0, 107117.0, 106898.0, 193243.0, 276669.0, 330307.0, 158552.0, 0.0, 111799.0, 154540.0, 224907.0},
//                {261728.0, 138809.0, 174816.0, 579557.0, 180783.0, 95380.0, 132942.0, 72029.0, 183575.0, 523957.0, 421916.0, 340148.0, 302812.0, 279828.0, 252518.0, 223220.0, 61366.0, 177881.0, 342776.0, 25363.0, 66042.0, 78463.0, 215092.0, 239727.0, 284627.0, 129239.0, 116935.0, 0.0, 170975.0, 126252.0},
//                {397323.0, 311831.0, 347838.0, 715152.0, 350448.0, 268402.0, 305964.0, 245051.0, 355279.0, 678956.0, 582576.0, 513170.0, 474516.0, 415423.0, 388113.0, 381395.0, 132361.0, 190252.0, 212138.0, 194168.0, 218444.0, 120191.0, 59877.0, 272239.0, 216522.0, 180392.0, 163127.0, 170867.0, 0.0, 283975.0},
//                {298904.0, 134404.0, 158164.0, 582574.0, 176378.0, 99445.0, 102365.0, 96434.0, 126692.0, 479450.0, 405264.0, 306305.0, 245929.0, 274888.0, 250530.0, 218815.0, 174246.0, 227142.0, 455656.0, 97889.0, 148339.0, 191343.0, 327972.0, 288199.0, 374925.0, 175666.0, 229815.0, 125281.0, 283855.0, 0.0}
//        };
        double[][] road  = new double[][]{
                {0.0, 22418.0, 2729.0, 11899.0, 16670.0, 16492.0, 20130.0, 15645.0},
                {21095.0, 0.0, 20006.0, 18655.0, 4615.0, 14047.0, 5688.0, 6633.0},
                {1541.0, 20129.0, 0.0, 9610.0, 17033.0, 14203.0, 17841.0, 16469.0},
                {11276.0, 19368.0, 10187.0, 0.0, 20432.0, 8043.0, 14852.0, 19868.0},
                {16641.0, 5309.0, 16658.0, 19490.0, 0.0, 15566.0, 6267.0, 2542.0},
                {16316.0, 15392.0, 15227.0, 6010.0, 16195.0, 0.0, 10876.0, 13998.0},
                {20749.0, 6546.0, 19660.0, 15049.0, 5681.0, 10441.0, 0.0, 7171.0},
                {15262.0, 8002.0, 15279.0, 18796.0, 3183.0, 13651.0, 8291.0, 0.0}
        };
        for (int i = 0; i < road.length; i++) {
            for (int j = 0; j < road.length; j++) {
                road[i][j] = Double.valueOf(String.format("%.2f",  road[i][j]/10000 ));
            }
        }
        for (int i = 0; i < road.length; i++) {
            System.out.println(Arrays.toString(road[i]));
        }
    }

    @Test
    public void baiduMap() throws JsonProcessingException {
//        String[] citys = {"南京市","无锡市","江阴市","徐州市","常州市","苏州市","常熟市","吴江市","南通市","连云港市","淮安市","盐城市","东台市","扬州市","镇江市","丹阳市","杭州市","宁波市","温州市","嘉兴市","湖州市","绍兴市","金华市","舟山市","台州市","余姚市","临安市","桐乡市","义乌市","上海市"};
        String[] citys = {"上海华东理工大学徐汇校区","上海世纪公园","上海南站","上海中山公园","上海浦东图书馆","上海站","上海源深体育馆","上海大华北公园"};
        String[] lngLat = new String[citys.length];
        for (int i = 0; i < citys.length; i++) {
            ReceData receData = getLocation(citys[i]);
            Location location = receData.getResult().getLocation();
            String lngLatStr = String.format("%.6f",location.getLat())+","+String.format("%.6f",location.getLng());
//            String lngLatStr = String.format("%.6f",location.getLng())+","+String.format("%.6f",location.getLat());
            lngLat[i] = lngLatStr;
        }
        System.out.println(Arrays.toString(lngLat));

    }

    @Test
    public void road() throws JsonProcessingException {
//        String[] locations = {"32.06465,118.80242","31.49881,120.31858","31.92604,120.29157","34.21267,117.29058","31.81580,119.98148","31.30356,120.59241","31.65954,120.75950","31.14464,120.65157","31.98655,120.90159","34.60225,119.22862","33.61630,119.02148","33.35510,120.16754","32.87272,120.32654","32.40068,119.41942","32.19472,119.43049","32.01592,119.61250","30.25308,120.21551","29.86603,121.62857","28.00109,120.70648","30.75097,120.76355","30.89896,120.09452","30.03637,120.58548","29.08464,119.65344","29.99091,122.21356","28.66219,121.42743","30.04273,121.16059","30.23981,119.73152","30.63631,120.57154","29.31115,120.08158","31.23593,121.48054"};
        String[] locations = {"31.149538,121.430226",
                "31.222046,121.558979",
                "31.159439,121.435865",
                "31.227831,121.425511",
                "31.198316,121.547962",
                "31.255923,121.462056",
                "31.238645,121.544428",
                "31.185839,121.537908"};
        double[][] distances = new double[locations.length][locations.length];
        for (int i = 0; i < locations.length; i++) {
            String currentLocation = locations[i];
            for (int j = 0; j < locations.length; j++) {
                if (i==j){
                    distances[i][j]=0;
                    continue;
                }
                distances[i][j]=getRoadLength(currentLocation, locations[j]);
            }
        }
        for (int i = 0; i < distances.length; i++) {
            System.out.println(Arrays.toString(distances[i]));
        }
    }

    private double getRoadLength(String origin, String destination) throws JsonProcessingException {
        String result = baiduMapClient.getRoad(origin, destination, AK);
        ObjectMapper objectMapper = new ObjectMapper();
        RoadData roadData = objectMapper.readValue(result, RoadData.class);
        List<Routes>routes = roadData.getResult().getRoutes();
        Optional<Double> min =  routes.stream().map(Routes::getDistance).min(Double::compareTo);
        if (!min.isPresent()){
            System.out.println(min);
        }
        return min.get();
    }

    private ReceData getLocation(String address) throws JsonProcessingException {
        String result = baiduMapClient.getLatitudeAndLongitude(address, "json", AK);
        ObjectMapper objectMapper = new ObjectMapper();
        ReceData receData = objectMapper.readValue(result, ReceData.class);
        return receData;
    }

    @Test
    public void getAddr() throws JsonProcessingException {
//        System.out.println("上海华东理工大学徐汇校区" + getLocation("上海华东理工大学徐汇校区"));
//        System.out.println("上海世纪公园" + getLocation("上海世纪公园"));
//        System.out.println("上海南站" + getLocation("上海南站"));
//        System.out.println("上海中山公园" + getLocation("上海虹桥机场"));
//        System.out.println("上海浦东图书馆" + getLocation("上海浦东图书馆"));
//        System.out.println("上海站" + getLocation("上海站"));
//        System.out.println("上海源深体育馆" + getLocation("上海源深体育馆"));
//        System.out.println("上海大华北公园" + getLocation("上海迪士尼"));
        int[] order = {2, 0, 7, 4, 1, 6, 5, 3};
        String[] citys = {"上海华东理工大学徐汇校区","上海世纪公园","上海南站","上海中山公园","上海浦东图书馆","上海站","上海源深体育馆","上海大华北公园"};
//
//
        String[] locations = {"121.430226,31.149538",
                "121.558979,31.222046",
                "121.435865,31.159439",
                "121.425511,31.227831",
                "121.547962,31.198316",
                "121.462056,31.255923",
                "121.544428,31.238645",
                "121.537908,31.185839"};

        for (int tmp: order) {
            System.out.println(citys[tmp]);
        }
        for (int tmp: order) {
            System.out.println(locations[tmp]);
        }
    }




//    private getRoad
}
