package WangYi;

import java.util.Stack;

public class q1 {

        public static void main(String[] args) {
            getMatchBracketsNum(")",8);
        }
        /**
         * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
         * @param inString string字符串 待判断的字符串
         * @param inStringNum int整型 输入字符串长度
         * @return int整型
         */
        public static  int getMatchBracketsNum (String inString, int inStringNum) {
            Stack<Character> stack=new Stack<>();
            int res=0;
            for(int i=0;i<inString.length();++i) {
                char c=inString.charAt(i);
                if(c=='['||c=='('||c=='{')
                    stack.add(c);
                else if(stack.size()==0){
                    return -1;
                }
                else{
                    char temp=stack.peek();
                    if(temp=='('&&c==')'){
                        stack.pop();
                        res+=1;
                    }else if(temp=='['&&c==']'){
                        stack.pop();
                        res+=2;
                    }else if(temp=='{'&&c=='}'){
                        stack.pop();
                        res+=3;
                    }else
                        return -1;
                }

            }
            if(stack.size()!=0)
                return -1;
            System.out.println(res);
            return res;
        }

}
