package com.catherineliu.practice.main_code.aboutt_retrofit_and_rxjava;

import android.widget.TextView;

import com.catherineliu.practice.R;
import com.catherineliu.practice.about_base.BaseActivity;
import com.catherineliu.practice.about_utils.MyLog;
import com.catherineliu.practice.about_utils.StrUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 项目：Practice
 * 文件描述：RxJava界面
 * 作者：ljj
 * 创建时间：2020/4/22
 */
public class RxJavaActivity extends BaseActivity {

    @BindView(R.id.include_top_tv_title)
    TextView includeTopTvTitle;
    @BindView(R.id.tv_show_info)
    TextView tvShowInfo;
    @BindView(R.id.tv_show_info2)
    TextView tvShowInfo2;

    @Override
    protected int getLayoutView() {
        return R.layout.activity_rxjava;
    }

    @Override
    protected void initViewUI() {
        super.initViewUI();
        includeTopTvTitle.setText(getResources().getString(R.string.rxjava_title));

    }

    @Override
    protected void initData() {
        super.initData();

    }

    StringBuilder observerStrBuilder = new StringBuilder();
    StringBuilder observerStrBuilder2 = new StringBuilder();
//    final String[] observerStr = {""};
//    final String[] observerStr2 = {""};
    // 创建一个观察者
    Observer<String> observer = new Observer<String>() {

        @Override
        public void onNext(String s) {
/*            observerStr[0] = observerStr[0] + s;
            MyLog.i("Observer", "-------------" + s);
            tvShowInfo.setText(observerStr[0]);*/
            observerStrBuilder.append(s);
            MyLog.i("Observer", "-------------" + s);
            tvShowInfo.setText(observerStrBuilder.toString());
        }

        @Override
        public void onCompleted() {
            MyLog.i("Observer", "完成");
        }

        @Override
        public void onError(Throwable e) {
            MyLog.i("Observer", "错误" + e.toString());
        }
    };

    Subscriber<String> subscriber = new Subscriber<String>() {

        @Override
        public void onNext(String s) {
/*            observerStr[0] = observerStr[0] + s;
            MyLog.i("Observer", "-------------" + s);
            tvShowInfo.setText(observerStr[0]);*/
            observerStrBuilder.append(s);
            MyLog.i("Observer", "-------------" + s);
            tvShowInfo.setText(observerStrBuilder.toString());
        }

        @Override
        public void onCompleted() {
            MyLog.i("Observer", "完成");
        }

        @Override
        public void onError(Throwable e) {
            MyLog.i("Observer", "错误" + e.toString());
        }
    };

    private void BaseCreateForObservable() {
        // 创建被观察者
        // 法一
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Nice to meet ");
                subscriber.onNext("World!\n");
                subscriber.onCompleted();
            }
        });
        observable.subscribe(observer);
//        observable.subscribe(subscriber);

        // 法二
        Observable observable1 = Observable.just("Hello ", "World!\n");
        observable1.subscribe(observer);
//        observable1.subscribe(subscriber);

        // 法三
        String[] words = {"Hi ", "World!\n"};
        Observable observable2 = Observable.from(words);
        observable2.subscribe(observer);
//        observable2.subscribe(subscriber);

        // 法四
        List<String> list = new ArrayList<>();
        list.add("Nice to see ");
        list.add("World!\n");
        Observable observable3 = Observable.from(list);
        observable3.subscribe(observer);
//        observable3.subscribe(subscriber);
    }

    private void BaseUseForSubscribeAction() {
        // 原始使用
/*        Observable.just("Hello ", "World!   --", "Hi ", "U\n")
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onNext(String s) {
                        MyLog.i("Observer", "-----------Subscriber--" + s);
                        observerStr[0] = observerStr[0] + s;
                        tvShowInfo.setText(observerStr[0]);
                    }

                    @Override
                    public void onCompleted() {
                        MyLog.i("Observer", "完成");
                    }

                    @Override
                    public void onError(Throwable e) {
                        MyLog.i("Observer", "错误" + e.toString());
                    }

                });*/

        // 使用Action
/*        Observable.just("Hi ", "World!   --", "Hello ", "Me\n")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        MyLog.i("Observer", "-----------Action1--" + s);
                        observerStr2[0] =  observerStr2[0] + s;
                        tvShowInfo2.setText(observerStr2[0]);
                    }
                });*/

        // 定意三个对象,分别打包onNext(obj)、onError(error) 、onCompleted()
        // 处理onNext()中的内容
        Action1<String> onNextAction1 = new Action1<String>() {
            @Override
            public void call(String s) {
                MyLog.i("Observer", "-----------onNextAction1--" + s);
/*                observerStr[0] = observerStr[0] + s;
                tvShowInfo.setText(observerStr[0]);*/
                observerStrBuilder.append(s);
                tvShowInfo.setText(observerStrBuilder.toString());
            }
        };
        // 处理onError()中的内容
        Action1<Throwable> onErrorAction1 = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                MyLog.i("Observer", throwable.toString() + "-------------" + throwable.getMessage());
            }
        };
        // 处理onCompleted()中的内容
        Action0 onCompletedAction0 = new Action0() {
            @Override
            public void call() {
                MyLog.i("Observer", "完成");
            }
        };

        // 使用 onNextAction1 来定义 onNext()
        Observable.just("Hello ", "World\n").subscribe(onNextAction1);
        //使用 onNextAction1 和 onErrorAction1 来定义 onNext() 和 onError()
        Observable.just("Hi ", "World\n").subscribe(onNextAction1, onErrorAction1);
        // 使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
        Observable.just("Nice to see ", "World").subscribe(onNextAction1, onErrorAction1, onCompletedAction0);


    }

    private List<String> nameList = new ArrayList<>();
    private List<Integer> ageList = new ArrayList<>();
    private List<String> sexList = new ArrayList<>();
    private void BaseUseForMapFunc() {
        initStudentsData();

/*        Observable.just(dataStudent, dataStudents2, dataStudents3)
                .map(new Func1<DataStudents, String>() {
                    @Override
                    public String call(DataStudents dataStudents) {
                        MyLog.i("map", dataStudents.getName());
                        return dataStudents.getName();
                    }
                }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                MyLog.i("map", "name===" + s);
                nameList.add(s);
            }
        });

        String names = "";
        if (nameList.size() > 0) {
            for (String name : nameList){
                names = names + name + "\n";
            }
        }
        tvShowInfo.setText(names);*/

        //多次使用map，想用几个用几个
/*        Observable.just("Hello ", "World")
                .map(new Func1<String, byte[]>() {//将String类型的转化为byte[]类型的Bytes
                    @Override
                    public byte[] call(String s) {
                        Log.i("map", "s==" + s);
                        return s.getBytes();
                    }
                })
                .map(new Func1<byte[], String>() {//将转化后得到的byte[]类型的Bytes再转化为String类型
                    @Override
                    public String call(byte[] bytes) {
                        Log.i("map", "bytes==" + bytes);
                        return new String(bytes) + "";
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.i("map", s);
                        observerStr[0] = observerStr[0] + s;
                        tvShowInfo.setText(observerStr[0]);
                    }
                });*/


/*        // 打印课程
        Observable.from(studentsList).map(new Func1<DataStudents, List<DataStudents.Course>>() {
            @Override
            public List<DataStudents.Course> call(DataStudents dataStudents) {
                return dataStudents.getCoursesList();
            }
        }).subscribe(new Action1<List<DataStudents.Course>>() {
            @Override
            public void call(List<DataStudents.Course> courses) {
                for (DataStudents.Course course : courses){
                    observerStr[0] = observerStr[0] + course.getName() + "\n";
                    tvShowInfo.setText(observerStr[0]);
                }
            }
        });*/
/*        // 打印课程
        Observable.from(studentsList).flatMap(new Func1<DataStudents, Observable<DataStudents.Course>>() {
            @Override
            public Observable<DataStudents.Course> call(DataStudents dataStudents) {
                return Observable.from(dataStudents.getCoursesList());
            }
        }).subscribe(new Action1<DataStudents.Course>() {
            @Override
            public void call(DataStudents.Course course) {
                observerStr[0] = observerStr[0] + course.getName() + "\n";
                tvShowInfo.setText(observerStr[0]);
            }
        });*/

        ArrayList<DataStudents> dataStudents = new ArrayList<>();
        Observable.from(studentsList).flatMap(new Func1<DataStudents, Observable<DataStudents>>() {
            @Override
            public Observable<DataStudents> call(DataStudents dataStudent) {
                dataStudents.add(dataStudent);
                return Observable.from(dataStudents);
            }
        }).subscribe(new Action1<DataStudents>() {
            @Override
            public void call(DataStudents dataStudents) {
                List<DataStudents.Course> coursesList = dataStudents.getCoursesList();
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder courseSb = new StringBuilder();
                for (DataStudents.Course course : coursesList){
                    courseSb.append(course.getName()).append("/");
                }
                String s = "Name: " + dataStudents.getName() + "\n" + "Course: " + courseSb.toString();
                if (!observerStrBuilder.toString().contains(s)){
                    stringBuilder.append(s).append("\n\n");
                }
/*                observerStr[0] = observerStr[0] + dataStudents.getName() + stringBuilder.toString() + "\n";
                tvShowInfo.setText(observerStr[0]);*/
                observerStrBuilder.append(stringBuilder.toString());
                tvShowInfo.setText(observerStrBuilder.toString());

            }
        });

    }

    DataStudents dataStudent = new DataStudents();
    DataStudents dataStudent2 = new DataStudents();
    DataStudents dataStudent3 = new DataStudents();
    List<DataStudents> studentsList = new ArrayList<>();
    List<DataStudents.Course> courseList = new ArrayList<>();
    private void initStudentsData() {
        dataStudent.setName("Amy");
        dataStudent.setAge(20);
        dataStudent.setSex("female");
        DataStudents.Course course = new DataStudents.Course();
        course.setName("Chinese");
        course.setId(1);
        DataStudents.Course course2 = new DataStudents.Course();
        course2.setName("Math");
        course2.setId(2);
        DataStudents.Course course3 = new DataStudents.Course();
        course3.setName("English");
        course3.setId(3);
        courseList.add(course);
        courseList.add(course2);
        courseList.add(course3);
        dataStudent.setCoursesList(courseList);

        dataStudent2.setName("Bob");
        dataStudent2.setAge(22);
        dataStudent2.setSex("male");
        dataStudent2.setCoursesList(courseList);

        dataStudent3.setName("Catherine");
        dataStudent3.setAge(21);
        dataStudent3.setSex("female");
        dataStudent3.setCoursesList(courseList);

        studentsList.add(dataStudent);
        studentsList.add(dataStudent2);
        studentsList.add(dataStudent3);
    }

    @OnClick(R.id.btn_start)
    public void onViewClicked() {
        tvShowInfo.setText("");
        // Observable的基本使用
//        BaseCreateForObservable();

        // Action的基本使用
//        BaseUseForSubscribeAction();

        // Func1的基本使用
        BaseUseForMapFunc();

    }

}
