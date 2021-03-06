package cn.edu.pku.w2v;

import java.util.Collection;
import java.util.List;
import java.util.TreeSet;

/**
 * 构建Haffman编码树
 * @author ansj
 *目前尚未搞懂haffman树是用来干啥的。
 */
public class Haffman {
    private int layerSize;

    public Haffman(int layerSize) {
        this.layerSize = layerSize;
    }

	private TreeSet<Neuron> set = new TreeSet<>();

    public void make(Collection<Neuron> neurons) {
//        System.out.println("装载到树中");
    	set.addAll(neurons);
        while (set.size() > 1) {
//        	System.out.println("目前树中节点数"+set.size());
            //执行一次合并
        	merger();
        }
    }

	/**
	 * 这是执行一次合并，把最小的2个节点合并到一个大节点上
	 */
    private void merger() {
        // TODO Auto-generated method stub
        HiddenNeuron hn = new HiddenNeuron(layerSize);
//        System.out.println("移除最低的一个节点");
        Neuron min1 = set.pollFirst();
//        System.out.println("再移除最低的一个节点");
        Neuron min2 = set.pollFirst();
        //把两个频率加一起
        hn.freq = min1.freq + min2.freq;
        //置min1和min2的父节点为hn
        min1.parent = hn;
        min2.parent = hn;
        //置min1和2的code
        min1.code = 0;
        min2.code = 1;
//        System.out.println("把新创建的节点合并到树中");
        set.add(hn);
    }
    
}
