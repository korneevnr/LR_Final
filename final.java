import java.util.*; 
import java.io.*; 
import java.math.*; 
 
/** 
 * Auto-generated code below aims at helping you parse 
 * the standard input according to the problem statement. 
 **/ 
class Player { 
 
    public static void main(String args[]) { 
        Scanner in = new Scanner(System.in); 
        int xFlat; 
        int checkFlatX, checkFlatY; 
        int flatCounter = 0; 
        int yFlat; 
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars. 
        int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999) 
        int landY = in.nextInt(); 
        checkFlatY = landY; 
        checkFlatX = landX; 
        xFlat = landX; 
        yFlat = landY; 
        for (int i = 1; i < surfaceN; i++) { 
            landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999) 
            landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars. 
            if(landY == checkFlatY){ 
                flatCounter++; 
                if(flatCounter == 1){ 
                    xFlat = checkFlatX; 
                    yFlat = checkFlatY; 
                } 
            }else{ 
                checkFlatX = landX; 
                checkFlatY = landY; 
            } 
        } 
        int step = 0; 
        int point = 0; 
        int midlePoint = 0; 
        boolean side = true; 
        // game loop 
        while (true) { 
            int X = in.nextInt(); 
            int Y = in.nextInt(); 
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative. 
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative. 
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters. 
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90). 
            int power = in.nextInt(); // the thrust power (0 to 4). 
            if(step == 0){ 
                if(Math.abs(hSpeed)>2){ 
                    if(hSpeed < 0){ 
                        System.out.println("-23 4"); 
                    }else{ 
                        System.out.println("23 4"); 
                    } 
                }else{ 
                    step = 1; 
                    System.out.println("0 4"); 
                } 
            }else if(step == 1){ 
                if(Y > 270 + yFlat || vSpeed > 4){ 
                    step = 2; 
                } 
                System.out.println("0 4"); 
            }else if(step == 2){ 
                if(point == 0){ 
                    point = 1; 
                    midlePoint = (xFlat + 500 + X)/2; 
                    if(midlePoint > X){ 
                        side = true; 
                    }else{ 
                        side = false; 
                    } 
                    if(side){ 
                        System.out.println("-23 4"); 
                    }else{ 
                        System.out.println("23 4"); 
                    } 
                }else{ 
                    if(side && midlePoint > X){ 
                        System.out.println("-23 4"); 
                    }else if(!side && midlePoint < X){ 
                        System.out.println("23 4"); 
                    }else if(side && midlePoint <= X){ 
                        step = 3; 
                        System.out.println("23 4"); 
                    }else{ 
                        step = 3; 
                        System.out.println("-23 4"); 
                    } 
                } 
            }else if(step == 3){ 
                if(side && xFlat + 500 > X){ 
                            System.out.println("23 4"); 
                    }else if(!side && xFlat + 500 < X){ 
                        System.out.println("-23 4"); 
                    }else if(side && xFlat + 500 <= X){ 
                        step = 4; 
                        System.out.println("0 3"); 
                    }else{ 
                        step = 4;
                        System.out.println("0 3"); 
                    } 
            }else if(step == 4){ 
                if(Math.abs(hSpeed) > 1){ 
                    if(hSpeed<0){ 
                        System.out.println("-23 4"); 
                    }else{ 
                        System.out.println("23 4"); 
                    } 
                }else{ 
                    step = 5; 
                    System.out.println("0 3"); 
                } 
            }else if(step == 5){ 
                if(Math.abs(vSpeed)<30){ 
                    System.out.println("0 0"); 
                }else{ 
                    System.out.println("0 4"); 
                } 
            } 
        } 
    } 
}
