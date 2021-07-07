// MODELIL KAKS SUURT MÕTET:
// 1. teen ühe muudatuse, siis läheb kõikjale
// 2. ei pea pikalt igas failis lahti kirjutama --- segab liiga pikad read
// 3. lugemise mõttes ainult 1 sõna (ei pea hakkama süvenema, mis kõik võti-väärtused seal on)
// 4. kirjutan uut muutujat, piisab vaid 1 sõna kirjutamisest
// 5. kui lisan uut objekti sellest modelist, siis saan selle lihtsasti kokku koondada

export class Product {
  constructor(
    public imgSrc: string,
    public title: string,
    public price: number,
    public category: string
  ) {}

  // muutujad private ja getterid

  // {
    // imgSrc: string, 
    // title: string, 
    // price: number,
    //  category: string}
}

// export class Product2 {
//   private imgSrc: string;
//   private title: string;
//   private price: number;
//   private category: string;

//   constructor(
//       imgSrc: string,
//       title: string,
//       price: number,
//       category: string
//   ) {
//     this.imgSrc = imgSrc;
//     this.title = title;
//     this.price = price;
//     this.category = category;
//   }
  
// }