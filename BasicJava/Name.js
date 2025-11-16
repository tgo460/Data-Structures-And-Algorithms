const names = ['Alice', 'Bob', 'Charlie', 'David'];

for (let i = 0; i < names.length; i++) {    
    console.log(names[i], names.map((name, index) => index === i ? name.toUpperCase() : name));
}


