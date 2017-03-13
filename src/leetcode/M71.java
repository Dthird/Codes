package leetcode;

/**
 * Created by jiaxing on 17-3-13.
 */

/**
 * Simplify Path
 */
public class M71 {

    public String simplifyPath(String path) {
        if (path.length() == 0)
            return "";

        String[] ts = path.split("/");
        StringBuilder res = new StringBuilder("");
        for (int i = 0; i < ts.length; i++) {
            String s = ts[i];
            //System.out.println(s);
            if (s.equals(".") || s.equals("")){
                continue;
            }
            if (s.equals("..")){
                if (res.length() > 1){
                    res.delete(res.lastIndexOf("/"), res.length());
                }
                continue;
            }

            res.append("/" + s);
        }
        return res.length() == 0 ? "/" : res.toString();
    }

    public static void main(String[] args){
        M71 m71 = new M71();
        System.out.println(m71.simplifyPath("/home/c//./../"));
        StringBuilder test = new StringBuilder("/a/b/cd");
        /*test.delete(test.lastIndexOf("/"), test.length());
        System.out.println(test.toString());*/
    }
}
