/**
 * Created by Venkatesh Kadimisetty
 * Date: 7/15/2016.
 */

app.filter('makeUppercase', function () {
    return function (item) {
        var temp="";
        var arr=item.split(" ");
        for(i=0;i<arr.length;i++)
        {
            temp=temp+" "+arr[i].charAt(0).toUpperCase()+""+arr[i].slice(1).toLowerCase();
        }
        return temp;
    };
});