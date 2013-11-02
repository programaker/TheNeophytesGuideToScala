package part01.bool

import part01.multivalue.FreeUser

object IsPremiumCandidate {
  def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.75
}
