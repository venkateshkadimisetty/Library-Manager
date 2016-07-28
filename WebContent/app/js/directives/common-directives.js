/**
 * Created by Venkatesh Kadimisetty
 * Date: 7/15/2016.
 */
app.directive('numbersOnly', function () {
    return {
        require: 'ngModel',
        link: function (scope, element, attr, ngModelCtrl) {
            function fromUser(text) {
                if (text!='' && text!=undefined) {
                    var transformedInput = text.replace(/[^0-9]/g, '');

                    if (transformedInput !== text) {
                        ngModelCtrl.$setViewValue(transformedInput);
                        ngModelCtrl.$render();
                    }
                    return transformedInput;
                }
                return undefined;
            }
            ngModelCtrl.$parsers.push(fromUser);
        }
    };
});


app.directive('capitalizeFirst', function () {
    return {
        require: 'ngModel',
        scope: {
            ngModel: "="
        },
        link: function (scope, element, attrs, modelCtrl) {
            
            scope.$watch("ngModel", function () {
                scope.ngModel = scope.ngModel.replace(/^(.)|\s(.)/g, function(v){ return v.toUpperCase( ); });
            });
        }
    };
});