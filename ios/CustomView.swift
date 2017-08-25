//
//  CustomView.swift
//  RNArkitDemo
//
//  Created by Sean Tempesta on 8/25/17.
//  Copyright © 2017 Facebook. All rights reserved.
//

import UIKit

class CustomView: UIView {

  override init(frame: CGRect) {
    super.init(frame: frame)
    let label = UILabel(frame: CGRect(x: 0, y: 0, width: 100, height: 50))
    label.text = "This is Swift"
    self.addSubview(label)
  }
  required init?(coder aDecoder: NSCoder) {
    fatalError("init(coder:) has not been implemented")
  }
}
