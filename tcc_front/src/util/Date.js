export default {
    firstDayOfMonth() {
        var date = new Date();
        return new Date(date.getFullYear(), date.getMonth(), 1);    
    },
    lastDayOfMonth() {
        var date = new Date();
        return new Date(date.getFullYear(), date.getMonth() + 1, 0);    
    },
}
