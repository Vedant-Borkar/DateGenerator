import java.util.*;
class Dategenerator{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("ENTER Date: DD/MM/YYYY");
        System.out.println("Enter DD");
        int dd= sc.nextInt();
        System.out.println("Enter MM");
        int mm= sc.nextInt();
        System.out.println("Enter YYYY");
        int yyyy= sc.nextInt();
        System.out.println(dd+"/"+mm+"/"+yyyy);
        int days[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
        int months[]={1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println("Enter number of Days to be added");
        int d= sc.nextInt();
        int oy=yyyy,od=dd,om=mm;
        int rem=days[mm]-dd;
        if(d>rem){
            d=d-rem;
            if(mm<12)
                mm++;
            else {
                mm = 1;
                yyyy++;
            }
            if(d>days[mm]) {
                while (d > days[mm]) {
                    d = d - days[mm];
                    if (mm < 12)
                        mm = mm + 1;
                    else {
                        mm = 1;
                        yyyy++;
                    }
                }
                dd=d;
            }
            else{
                dd=d;
            }
        }else{
            dd=dd+d;
        }
        if(yyyy>oy) {
            if (yyyy % 4 == 0) {
                if ( yyyy % 400 == 0 || yyyy % 100 != 0) {
                    if(mm==3){
                        if(dd!=1){
                            dd=dd-1;
                        }
                        else{
                            dd=29;
                            mm=2;
                        }
                    }
                    else if(mm>2){
                        if(dd!=1){
                            dd=dd-1;
                        }
                        else{
                            if(mm!=1) {
                                dd = days[mm - 1];
                                mm = mm - 1;
                            }else{
                                dd = days[12];
                                mm = 12;
                                yyyy--;
                            }
                        }
                    }
                }
            }
            if(oy%4==0) {
                if( oy % 400 == 0 || oy % 100 != 0) {
                    if(om<=2){
                        if(dd!=1){
                            dd=dd-1;
                        }
                        else{
                            if(mm!=1) {
                                dd = days[mm - 1];
                                mm = mm - 1;
                            }else{
                                dd = days[12];
                                mm = 12;
                                yyyy--;
                            }
                        }
                    }
                }
            }
            int count=0;
            if(yyyy-oy>1){
                while(oy!=yyyy){
                    oy++;
                    if(oy%4==0) {
                        if (oy % 400 == 0 || oy % 100 != 0) {
                            count++;
                        }
                    }
                }
                if(count>0){
                    if(dd>count){
                        dd=dd-count;
                    }
                    else{
                        count=count-dd;
                        if(mm!=1) {
                            dd = days[mm - 1]-count;
                            mm = mm - 1;
                        }else{
                            dd = days[12]-count;
                            mm = 12;
                            yyyy--;
                        }
                    }
                }
            }
        }
        else if(oy%4==0){
            if((oy%100==0 && oy%400==0) || (oy%100!=0 && oy%4==0)){
                if(om<=2){
                    if(mm>2){
                        if(dd!=1){
                            dd=dd-1;
                        }
                        else{
                            if(mm!=1) {
                                dd = days[mm - 1];
                                mm = mm - 1;
                            }else{
                                dd = days[12];
                                mm = 12;
                                yyyy--;
                            }
                        }
                    }
                    if (yyyy==oy && mm==2){
                        if(dd+d==29){
                            dd=29;
                        }
                    }
                }
            }
        }

        System.out.println("Final Date:");
        System.out.println(dd+"/"+mm+"/"+yyyy);
    }
}