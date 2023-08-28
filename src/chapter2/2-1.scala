// 2.1

// - 純粋関数
//     - 関数の戻り値は常に１つだけ
//     - 関数は引数にのみ基づいて戻り値を計算する
//     - 関数は既存の値を変更しない

// 2.10

// class TipCalculator {
//     private List<String> names = new ArrayList<>();

//     public List<String> addPerson(List<String> names, String name) {
//         List<String> updated = new ArrayList(names);
//         updated.add(name);
//         return updated;
//     }

//     public static int getTipPercentage(List<String> names) {
//         if (names.size() > 5) {
//             return 20
//         } else if (names.size() > 0) {
//             return 10
//         } else {
//             return 0
//         }
//     }
// }