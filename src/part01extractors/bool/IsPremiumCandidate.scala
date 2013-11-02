package part01extractors.bool

import part01extractors.multivalue.FreeUser

object IsPremiumCandidate {
  def unapply(user: FreeUser): Boolean = user.upgradeProbability > 0.75
}
