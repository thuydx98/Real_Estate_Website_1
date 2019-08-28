// Dashboard 1 Morris-chart

//Morris.Area({
//    element: 'morris-area-chart',
//    data: [{
//        period: '2012',
//        Python: 0,
//        PHP: 0,
//        Java: 0
//    }, {
//        period: '2013',
//        Python: 100,
//        PHP: 80,
//        Java: 65
//    }, {
//        period: '2014',
//        Python: 180,
//        PHP: 150,
//        Java: 120
//    }, {
//        period: '2015',
//        Python: 100,
//        PHP: 70,
//        Java: 40
//    }, {
//        period: '2016',
//        Python: 180,
//        PHP: 150,
//        Java: 120
//    }, {
//        period: '2017',
//        Python: 100,
//        PHP: 70,
//        Java: 40
//    },
//    {
//        period: '2018',
//        Python: 180,
//        PHP: 150,
//        Java: 120
//    }],
//    xkey: 'period',
//    ykeys: ['Python', 'PHP', 'Java'],
//    labels: ['Python', 'PHP', 'Java'],
//    pointSize: 0,
//    fillOpacity: 0.99,
//    pointStrokeColors: ['#65b12d', '#933EC5 ', '#006DF0'],
//    behaveLikeLine: true,
//    gridLineColor: '#e0e0e0',
//    lineWidth: 0,
//    hideHover: 'auto',
//    lineColors: ['#65b12d', '#933EC5 ', '#006DF0'],
//    resize: true

//});

Morris.Area({
    element: 'extra-area-chart',
    data: [{
        period: '2010',
        Posts: 50,
        UsersOnline: 80
    }, {
        period: '2011',
        Posts: 130,
        UsersOnline: 100
    }, {
        period: '2012',
        Posts: 80,
        UsersOnline: 60
    }, {
        period: '2013',
        Posts: 70,
        UsersOnline: 200
    }, {
        period: '2014',
        Posts: 180,
        UsersOnline: 150
    }, {
        period: '2015',
        Posts: 105,
        UsersOnline: 100
    },
    {
        period: '2016',
        Posts: 250,
        UsersOnline: 150
    }],
    xkey: 'period',
    ykeys: ['Posts', 'UsersOnline'],
    labels: ['Posts', 'UsersOnline'],
    pointSize: 3,
    fillOpacity: 0,
    pointStrokeColors: ['#006DF0', '#933EC5'],
    behaveLikeLine: true,
    gridLineColor: '#e0e0e0',
    lineWidth: 1,
    hideHover: 'auto',
    lineColors: ['#006DF0', '#933EC5'],
    resize: true

});