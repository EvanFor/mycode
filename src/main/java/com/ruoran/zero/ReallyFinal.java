package com.ruoran.zero;

/**
 * 如果你觉得是因为反射导致你程序慢的话，那么，请先用放慢镜好好观察一下，到底是不是反射的问题。如果你确定是反射的问题，那么你再好好的考虑下是不是你没有用对反射，是不是像上面那个走了一百万遍都不认识路的快递员一样。最后，如果你觉得性能上还是不够，那么我建议你升级下硬件吧，把硬件性能上升个3%总好过你请个牛逼的工程师来帮你做这种极限的优化，有一句话我觉得很对“工程师比服务器要昂贵的多”。
 */
public class ReallyFinal {

    public final int x;

    public ReallyFinal(int c) {
        this.x = c;
    }

    public static void main(String[] args) {
        ReallyFinal x = new ReallyFinal(1);
        System.out.println(x.x);

        ReallyFinal y = new ReallyFinal(2);
        System.out.println(y.x);
    }
}
