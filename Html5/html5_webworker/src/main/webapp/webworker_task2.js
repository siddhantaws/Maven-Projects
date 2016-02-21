self.addEventListener('message', function(e) {
  self.postMessage("Hello, " + e.data.name + " Your age is " + e.data.age);
}, false);