package Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author 黄建军
 * @version V1.0
 * @Package Test
 * @date 2020/7/6 23:09
 * @Copyright © 2016-2019 上海乐刚供应链股份有限公司
 */
public class CollectionDemo {
        public static void main(String[] args) {
            List<VideoOrder> videoOrders1 = new ArrayList<>();
            videoOrders1.add(new VideoOrder("a课程", 22));
            videoOrders1.add(new VideoOrder("w课程", 200));
            videoOrders1.add(new VideoOrder("c课程", 100));
            videoOrders1.add(new VideoOrder("d课程", 33));
            videoOrders1.add(new VideoOrder("f课程", 1));
            List<VideoOrder> videoOrders2 = new ArrayList<>();
            videoOrders2.add(new VideoOrder("a课程", 22));
            videoOrders2.add(new VideoOrder("b课程", 18));
            videoOrders2.add(new VideoOrder("d课程", 33));
            videoOrders2.add(new VideoOrder("f课程", 1));
            videoOrders2.add(new VideoOrder("z课程", 22));


            //交集第一种
            videoOrders1.retainAll(videoOrders2);
            System.out.println(videoOrders1);

            //交集第二种
            List<VideoOrder> intersectionList=new ArrayList<>();
            //遍历videoOrders1
            for (VideoOrder videoOrder: videoOrders1 ) {
                //通过videoOrders2来判断是否有videoOrders1的同名元素
                if(videoOrders2.contains(videoOrder)){
                    intersectionList.add(videoOrder);
                }
            }
            System.out.println(intersectionList);

            //并集第一种如果上面不注释则求出了是交集，而交集之后在运行差集则为空
            videoOrders1.addAll(videoOrders2);
            System.out.println(videoOrders1);
            System.out.println("=====================================");
            //去重并集
            Set<VideoOrder> set =new HashSet<>(videoOrders1);
            System.out.println(set);


            //差集第一种,如果上面不注释则求出了是交集，而交集之后在运行差集则为空
            videoOrders1.removeAll(videoOrders2);
            System.out.println(videoOrders1);

             //差集第二种
            List<VideoOrder> diffList=new ArrayList<>();
            //同样遍历VideoOrder1
            for (VideoOrder videoOrder: videoOrders1) {
                //交集判断是包含，差集是不包含
                if(!videoOrders2.contains(videoOrder)){
                    diffList.add(videoOrder);
                }
            }
            System.out.println(diffList);

            //testCollection();
          }

    /**
     *
     *  思路是先把字符串转换为字符数组，然后放入到对应关系里面map集合，
     *  通过key来判断value是否存在，不存在则设置为1
     *  如果存在则设置+1，并放入到map集合里面去，
     *  然后通过遍历得到每个字符在字符串中出现的次数
     */
    public static void testCollection(){

        String str="*Constructs a new <tt>HashMap</tt> ⼩滴课堂 with the same mappings as the *⼩滴课堂 specified <tt>Map</tt>. The <tt>HashMap</tt> " +
                    "is created with defaultload factor (0.75) and an initial capacity sufficient to*hold the mappings " +
                    "in the specified <tt>Map</tt>.";
            //把字符串转换为字符数组
            char [] chars=str.toCharArray();
            //看每个字符是否存在，不存在设置为1，存在则设置+1,创建一个map
            Map<Character,Integer> counterMap=new HashMap<>();

            //便利数组
            for(int i=0;i<chars.length;i++){
                //每遍历一个字符判断是否存在key
               Integer value= counterMap.get(chars[i]);
               //判断对应的字符key是否存在value如果不存在则设置为1
               if (value==null){
                   counterMap.put(chars[i],1);
                //存在则设置+1
               }else {
                   value+=1;
                   counterMap.put(chars[i],value);
               }
            }
            //存入到了map里面之后然后在进行遍历map
            Set<Map.Entry<Character,Integer>> entrySet= counterMap.entrySet();
            //增强for循环
//            for (Map.Entry<Character,Integer> entry:entrySet){
//                System.out.println(entry.getKey()+"字符出现的次数"+entry.getValue());
//            }
            //迭代器遍历
            Iterator<Map.Entry<Character,Integer>> iterator=entrySet.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character,Integer> map=  iterator.next();
                System.out.println(map.getKey()+"字符出现的次数"+map.getValue());
            }
        }


static class VideoOrder {
        private int price;
        private String title;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoOrder that = (VideoOrder) o;
        return price == that.price &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, title);
    }

    @Override
    public String toString() {
        return "VideoOrder{" +
                "price=" + price +
                ", title='" + title + '\'' +
                '}';
    }

    public VideoOrder(String title, int price) {
            this.title = title;
            this.price = price;}

        public int getPrice() {
            return price;
        }
        public void setPrice(int price) {
            this.price = price;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
    }


}
